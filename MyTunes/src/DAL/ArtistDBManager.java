/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Artist;
import BLL.ArtistManager;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class ArtistDBManager
{
    private SQLServerDataSource dataSource;
    private ArtistManager am = null;
    
    public ArrayList<Artist> ArtistId;
    public ArrayList<Artist> ArtistName;
    public ArrayList<Artist> AllArtists;

    public Artist addArtist(Artist artist) throws SQLServerException
    {
       String sql = "INSERT INTO Artist VALUES(?)";
       Connection con = dataSource.getConnection();
       PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
       ps.setString(1, am.getArtistByName());
               
    }
    
    public ArrayList<Artist> getArtistName()
    {
        String sql = "INSERT INTO Artist;
       Connection con = dataSource.getConnection();
    }
    
}
