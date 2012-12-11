/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Artist;
import DAL.ArtistDBManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class ArtistManager
{
    private ArtistDBManager adb = null;
            
    public ArtistManager() throws IOException
    {
        adb = new DAL.ArtistDBManager();
    }
    
    public ArrayList<Artist> getAllArtist() throws SQLException
    {
        return adb.getAllArtist();
    }
    
    public Artist getArtistById() throws SQLException
    {
        return adb.getArtistId();
    }
    
    public Artist getArtistByName(String name) throws SQLException
    {
        return adb.getArtistName(name);
    }
    
    public Artist addArtist(Artist artist) throws SQLException
    {
        return adb.addArtist(artist);
    }
    
 
}
