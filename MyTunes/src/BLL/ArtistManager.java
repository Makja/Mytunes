/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Artist;
import DAL.ArtistDBManager;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class ArtistManager
{
    private ArtistDBManager adb = null;
            
    public ArtistManager()
    {
        adb = new DAL.ArtistDBManager();
    }
    
    public ArrayList<Artist> getArtistById()
    {
        return adb.ArtistId;
    }
    
    public ArrayList<Artist> getArtistByName()
    {
        return adb.ArtistName;
    }
    
    public 
           
    
}
