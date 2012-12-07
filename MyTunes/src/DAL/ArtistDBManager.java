/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Artist;
import BE.Category;
import BE.Song;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class ArtistDBManager
{

    private SQLServerDataSource dataSource;

    public ArrayList<Artist> getAllArtist() throws SQLException
    {
        try (Connection con = dataSource.getConnection())
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM artist");

            ArrayList<Artist> artists = new ArrayList<>();

            while (rs.next())
            {
                int artistId = rs.getInt("Id");
                String artistName = rs.getString("Name");

                Artist a = new Artist(artistId, artistName);
                artists.add(a);
            }
            return artists;
        }

    }

    public ArrayList<Artist> getArtistId() throws SQLServerException, SQLException
    {
        try (Connection con = dataSource.getConnection())
        {
            Statement st = con.createStatement();
            String sql("SELECT * FROM Employee WHERE ID Like ?");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, IN);

            ArrayList<Artist> artists = new ArrayList<>();

            while (ps.next())
            {
                int artistId = ps.getInt("Id");

                Artist a = new Artist(artistId);
                artists.add(a);
            }
            return artists;
        }

    }

    public ArrayList<Artist> getArtistName()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
