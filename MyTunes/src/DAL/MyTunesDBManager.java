/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Song;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class MyTunesDBManager
{

    private SQLServerDataSource dataSource;

    public MyTunesDBManager() throws Exception
    {
        Properties props = new Properties();
        props.load(new FileReader("MyTunes.cfg"));

        dataSource = new SQLServerDataSource();

        dataSource.setServerName(props.getProperty("SERVER"));
        dataSource.setPortNumber(Integer.parseInt(props.getProperty("PORT")));
        dataSource.setDatabaseName(props.getProperty("DATABASE"));
        dataSource.setUser(props.getProperty("USER"));
        dataSource.setPassword(props.getProperty("PASSWORD"));
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    public ArrayList<Song> Search() throws SQLException
    {
        try (Connection con = dataSource.getConnection())
        {
            Scanner sc = new Scanner(System.in, "ISO-8859-1");
            System.out.println("Indtast Søgeord");
            String searchString = sc.nextLine();
            String sql = "SELECT * FROM artist JOIN Song ON artist.id = Song.artistID JOIN Category ON Category.id = Song.categoryID"
                    + " WHERE artist.Name LIKE ? OR Song.title LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, searchString);
            ps.setString(2, searchString);

            ResultSet rs = ps.executeQuery();
            
            ArrayList<Song> songs = new ArrayList<>();
            
            while(rs.next())
            {
                int id = rs.getInt("Id");
                String title = rs.getString("Title");
                String artist = rs.getString("Name");
                String category = rs.getString("Category");
                String fileName = rs.getString("Filename");
                int duration = rs.getInt("Duration");

                Song s = new Song(id, title, artist, category, fileName, duration);
                songs.add(s);
            }
            return songs;
        }

    }
}
