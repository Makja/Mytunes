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
 * @author Mak
 */
public class SongManager
{

    private SongDBManager sdb = null;
    private ArtistManager am = null;
    private CategoryManager cm = null;

    public SongManager() throws SQLException, IOException
    {
        sdb = new SongDBManager();
        cm = new CategoryManager();
        am = new ArtistManager();
    }

    public ArrayList<Song> Search() throws SQLException
    {
        return sdb.Search();
    }

    public ArrayList<Song> ListAll() throws SQLException
    {
        return sdb.ListAll();
    }

    public Song AddSong(Song s) throws SQLException
    {
        return sdb.AddSong(s);
    }
    
    public void RemoveSong(String title) throws SQLException
    {
        sdb.RemoveSong(title);
    }
}
