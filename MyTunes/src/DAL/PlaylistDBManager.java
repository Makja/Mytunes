/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Artist;
import BE.Category;
import BE.PlayList;
import BE.Song;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
                Calendar created = new GregorianCalendar();
                created.setTime(rs.getDate("Created"));

                PlayList p = new PlayList(playlistId, playlistName, created);
                playlists.add(p);
            }
            return playlists;
        }
    }
     public void removePlaylist(String name) throws SQLException
    {
        String sql = "DELETE FROM PlayList WHERE PlayList.Name = ?";
        
        Connection con = dataSource.getConnection();
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);
        
        int affectedRows = ps.executeUpdate();
        if (affectedRows == 0)
        {
            throw new SQLException("Unable to delete Playlist");
        }                
    }


    public ArrayList<Song> getSongsInPlaylist(int ID) throws SQLException
    {
        try (Connection con = dataSource.getConnection())
        { 
            String sql = "SELECT Song.*, Artist.Name, Category.Category FROM Song, PlayListSong, PlayList, Artist, Category "
                    + "WHERE PlayList.ID = PlayListSong.PlayListID AND PlayListSong.SongID = Song.ID AND "
                    + "Song.ArtistID = Artist.ID AND Song.CategoryID = Category.ID AND PlayList.ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ID);


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
    
    public PlayList addPlaylist(PlayList p) throws SQLException
    {
        
        Connection con = dataSource.getConnection();

        String sql = "INSERT INTO PlayList(Name, Created)" + ""
                + "VALUES(?,getDate())";
        PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        
        ps.setString(1, p.getName());

        int affectedRows = ps.executeUpdate();
        if (affectedRows == 0)
        {
            throw new SQLException("Unable to add Playlist");
        }

        ResultSet keys = ps.getGeneratedKeys();
        keys.next();
        int playlistId = keys.getInt(1);

        return new PlayList(playlistId, p);
    }
}
