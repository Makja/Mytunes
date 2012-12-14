/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Artist;
import BE.Song;
import DAL.ArtistDBManager;
import DAL.SongDBManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Daniel, Jonas, Mak
 */
public class ArtistManager
{
    private ArtistDBManager adb = null;
    private SongDBManager sdb = null;
            
    /**
     *Constructor
     * @throws IOException
     */
    public ArtistManager() throws IOException
    {
        adb = new DAL.ArtistDBManager();
    }
    
    /**
     *Henter alle artister fra databasen
     * @return
     * @throws SQLException
     */
    public ArrayList<Artist> getAllArtist() throws SQLException
    {
        return adb.getAllArtist();
    }
    
    /**
     *Henter en artist via id
     * @return
     * @throws SQLException
     */
    public Artist getArtistById() throws SQLException
    {
        return adb.getArtistId();
    }
    
    /**
     *Henter artisten via navnet
     * @param artistName
     * @return
     * @throws SQLException
     */
    public Artist getArtistByName(String artistName) throws SQLException
    {
        return adb.getArtistName(artistName);
    }
    
    /**
     *Tilføjer en artist med navnet artist
     * @param artist
     * @return
     * @throws SQLException
     */
    public Artist addArtist(Artist artist) throws SQLException
    {
        return adb.addArtist(artist);
    }
    
    /**
     *Updatere artist
     * @param s
     * @throws SQLException
     */
    public void updateArtist(Song s) throws SQLException
    {
        sdb.update(s);
    }
 
}
