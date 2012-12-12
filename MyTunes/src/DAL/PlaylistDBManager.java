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
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class PlaylistDBManager extends ConnectionDBManager
{

    public PlaylistDBManager() throws IOException  
    {
        
//    }
//     public ArrayList<PlayList> getAllPlaylists() throws SQLException
//    {
//       try (Connection con = dataSource.getConnection())
//        {
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM Playlist");
//
//            ArrayList<Playlist> playlists = new ArrayList<>();
//
//            while (rs.next())
//            {
//                int id = rs.getInt("ID");
//                String title = rs.getString("Title");
//                String artistName = rs.getString("Name");
//                String categoryName = rs.getString("Category");
//                String fileName = rs.getString("Filename");
//                int duration = rs.getInt("Duration");
//
//                Song s = new Song(id, title, new Artist(artistName), new Category(categoryName), fileName, duration);
//                songs.add(s);
//            }
//            return ;
        }
}
