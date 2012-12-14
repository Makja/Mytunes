/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.PlayList;
import BE.Song;
import DAL.PlaylistDBManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class PlaylistManager
{
    private PlaylistDBManager pdb = null;
    
    public PlaylistManager() throws IOException
    {
        pdb = new PlaylistDBManager();
    }
    
    public ArrayList<PlayList> getAllPlaylists() throws SQLException
    {
        return pdb.getAllPlaylists();
    }
    public ArrayList <Song> getSongsInPlaylist(int ID) throws SQLException
    {
        return pdb.getSongsInPlaylist(ID);
    }
//    public ArrayList<Playlist> AddPlaylist()
//    {
//        return pdb.addPlaylist();
//    }
    
    
    public void removePlaylist(int ID) throws SQLException
    {
        pdb.removePlaylist(ID);
    }
}
