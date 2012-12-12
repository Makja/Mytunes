/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.PlayList;
import DAL.PlaylistDBManager;
import java.io.IOException;
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
    
//    public ArrayList<PlayList> getAllPlaylists()
//    {
//        return pdb.getAllPlaylists;
//    }
//    public ArrayList<PlayList> getAllSongsInPlaylist()
//    {
//        return pdb.getAllSongsInPlaylist();
//    }
//    public ArrayList<PlayList> getTimeCreated()
//    {
//        return pdb.getTimeCreated;
//    }
}
