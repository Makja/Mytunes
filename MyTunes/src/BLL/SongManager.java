/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Artist;
import BE.Category;
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

        Artist artist = am.getArtistByName(s.getArtist().getArtistName());
        if (artist == null)
        {
            artist = am.addArtist(artist);
        }
        s.setArtist(artist);



        Category category = cm.getCategoryByName(s.getCategory().getCategoryName());
        if (category == null)
        {
            category = cm.addCategory(category);
        }
        s.setCategory(category);

        return sdb.AddSong(s);
    }
}