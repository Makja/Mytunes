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
    private PlayList p;
    
    public PlaylistDBManager() throws IOException  
    {
        
    }
     public ArrayList<PlayList> getAllPlaylists() throws SQLException
    {
       try (Connection con = dataSource.getConnection())
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Playlist");

            ArrayList<PlayList> playlists = new ArrayList<>();

            while (rs.next())
            {
                int playlistId = rs.getInt("ID");
                String playlistName = rs.getString("Name");
                String created = rs.getString("Created");
                
                PlayList p = new PlayList(playlistId, playlistName, created);
                playlists.add(p);
            }
            return playlists;
        }
    }
}

