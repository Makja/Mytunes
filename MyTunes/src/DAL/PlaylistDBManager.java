/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Artist;
import BE.Category;
import BE.PlayList;
import BE.Song;
import BLL.PlaylistManager;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class PlaylistDBManager extends ConnectionDBManager
{
    
    
    private PlayList p;

    public PlaylistDBManager() throws IOException
    {
    }

    public ArrayList<PlayList> getAllPlaylists() throws SQLException
    {
        try (Connection con = dataSource.getConnection())
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT PlayList.* FROM Playlist");

            ArrayList<PlayList> playlists = new ArrayList<>();

            while (rs.next())
            {
                int playlistId = rs.getInt("ID");
                String playlistName = rs.getString("Name");
                Date created = rs.getDate("Created");

                PlayList p = new PlayList(playlistId, playlistName, created);
                playlists.add(p);
            }
            return playlists;
        }
    }
     public void removePlaylist(int ID) throws SQLException
    {
        String sql = "DELETE FROM Playlist WHERE PlayListID = ?";
        
        Connection con = dataSource.getConnection();
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, ID);
        
        int affectedRows = ps.executeUpdate();
        if (affectedRows == 0)
        {
            throw new SQLException("Unable to delete Playlist");
        }                
    }


    public ArrayList<Song> getSongsInPlaylist() throws SQLException
    {
        try (Connection con = dataSource.getConnection())
        { 
            Scanner sc = new Scanner(System.in, "ISO-8859-1");
            System.out.print("Indtast PlayList Id: ");
            int sint = sc.nextInt();
            String sql = "SELECT Song.*, Artist.Name, Category.Category FROM Song, PlayListSong, PlayList, Artist, Category "
                    + "WHERE PlayList.ID = PlayListSong.PlayListID AND PlayListSong.SongID = Song.ID AND "
                    + "Song.ArtistID = Artist.ID AND Song.CategoryID = Category.ID AND PlayList.ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, sint);


            ResultSet rs = ps.executeQuery();
            ArrayList<Song> songs = new ArrayList<>();

            while (rs.next())
            {
                int id = rs.getInt("ID");
                String title = rs.getString("Title");
                String artistName = rs.getString("Name");
                String categoryName = rs.getString("Category");
                String fileName = rs.getString("Filename");
                int duration = rs.getInt("Duration");
                int artistId = rs.getInt("ArtistID");
                int categoryId = rs.getInt("CategoryID");

                Song s = new Song(id, title,  new Artist(artistId,artistName), new Category(categoryId,categoryName), fileName, duration);
                songs.add(s);
            }
            return songs;
        }
    }
    
//    public PlayList addPlaylist(PlayList p) throws SQLException
//    {
//        
//        Connection con = dataSource.getConnection();
//
//        String sql = "INSERT INTO PlayList(ID, Name, Created)" + ""
//                + "VALUES(?,?,?)";
//        PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
//        ps.setInt(1, p.getId());
//        ps.setString(2, p.getName());
////        ps.setDate(3, p.getCreated(created));
//        
//
//
//        int affectedRows = ps.executeUpdate();
//        if (affectedRows == 0)
//        {
//            throw new SQLException("Unable to add Song");
//        }
//
//        ResultSet keys = ps.getGeneratedKeys();
//        keys.next();
//        int id = keys.getInt(1);
//
//        return new Song(id, s);
//    }
}
