/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Artist;
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
 * @author Daniel, Jonas, Mak 
 */
public class ArtistDBManager extends ConnectionDBManager
{

    
    /**
     *Constructor
     * @throws IOException
     */
    public ArtistDBManager() throws IOException
    {
     
    }

    /**
     *Henter alle artister fra databasen
     * @return
     * @throws SQLException
     */
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

    /**
     *Henter en artist med et specifikt id
     * @return
     * @throws SQLException
     */
    public Artist getArtistId() throws SQLException
    {
        try (Connection con = dataSource.getConnection())
        {
            Scanner sc = new Scanner(System.in, "ISO-8859-1");
            int searchString = sc.nextInt();
            String sql = ("SELECT * FROM Artist WHERE ID = ?");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, searchString);


            ResultSet rs = ps.executeQuery();

            if (rs.next())
            {
                int artistId = rs.getInt("Id");
                String artistName = rs.getString("Name");

                Artist a = new Artist(artistId, artistName);
                
                return a;
               
            }
            return null;
        }

    }

    /**
     *Henter en artist med et specifikt navn
     * @param artistName
     * @return
     * @throws SQLException
     */
    public Artist getArtistName(String artistName) throws SQLException
    {

        try (Connection con = dataSource.getConnection())
        {
            String sql = ("SELECT * FROM Artist WHERE Name Like ?");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, artistName);


            ResultSet rs = ps.executeQuery();

            if (rs.next())
            {
                int Id = rs.getInt("ID");
                String name = rs.getString("Name");

                Artist a = new Artist(Id, name);
                return a;
            }
            return null;
        }

    }

    /**
     *Tilføjer en artist 
     * @param artist
     * @return
     * @throws SQLException
     */
    public Artist addArtist(Artist artist) throws SQLException
    {
        String sql = "INSERT INTO Artist VALUES (?)";
        Connection con = dataSource.getConnection();

        PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        
        ps.setString(1, artist.getArtistName());

        int affectedRows = ps.executeUpdate();
        if (affectedRows == 0)
        {
            throw new SQLException("Unable to insert Artist");
        }

        ResultSet keys = ps.getGeneratedKeys();
        keys.next();
        int id = keys.getInt(1);
        
        return new Artist(id, artist.getArtistName());

    }
}
