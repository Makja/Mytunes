/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Song;
import DAL.SongDBManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Mak, Jonas, Daniel
 */
public class SongManager
{

    private SongDBManager sdb = null;
    private ArtistManager am = null;
    private CategoryManager cm = null;

    /**
     *Constructor
     * @throws SQLException
     * @throws IOException
     */
    public SongManager() throws SQLException, IOException
    {
        sdb = new SongDBManager();
        cm = new CategoryManager();
        am = new ArtistManager();
    }

    /**
     *Søger efter en sang ved at indtaste titel eller artist
     * @return
     * @throws SQLException
     */
    public ArrayList<Song> Search() throws SQLException
    {
        return sdb.Search();
    }

    /**
     *Henter alle sange
     * @return
     * @throws SQLException
     */
    public ArrayList<Song> ListAll() throws SQLException
    {
        return sdb.ListAll();
    }

    /**
     *Tilføjer en sang
     * @param s
     * @return
     * @throws SQLException
     */
    public Song AddSong(Song s) throws SQLException
    {
        return sdb.AddSong(s);
    }
    
    /**
     *Sletter en sang
     * @param title
     * @throws SQLException
     */
    public void RemoveSong(String title) throws SQLException
    {
        sdb.RemoveSong(title);
    }
    
    /**
     *Updatere en sang
     * @param s
     * @throws SQLException
     */
    public void updateSong(Song s) throws SQLException
    {
        sdb.update(s);
    }
    
    /**
     *Henter sang via id
     * @param Id
     * @return
     * @throws SQLException
     */
    public Song getById(int Id) throws SQLException
    {
        return sdb.getById(Id);
    }
    
    
}
