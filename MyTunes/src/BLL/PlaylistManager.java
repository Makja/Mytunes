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
 * @author Daniel, Jonas, Mak
 */
public class PlaylistManager
{
    private PlaylistDBManager pdb = null;
    
    /**
     *Constructor 
     * @throws IOException
     */
    public PlaylistManager() throws IOException
    {
        pdb = new PlaylistDBManager();
    }
    
    /**
     *Henter alle playlists
     * @return
     * @throws SQLException
     */
    public ArrayList<PlayList> getAllPlaylists() throws SQLException
    {
        return pdb.getAllPlaylists();
    }
    /**
     *Henter alle sange i en given playlist
     * @param ID
     * @return
     * @throws SQLException
     */
    public ArrayList <Song> getSongsInPlaylist(int ID) throws SQLException
    {
        return pdb.getSongsInPlaylist(ID);
    }
    
    /**
     *Tilføjer en playlist
     * @param p
     * @return
     * @throws SQLException
     */
    public PlayList AddPlaylist(PlayList p) throws SQLException
    {
        return pdb.addPlaylist(p);
    }
    
    
    /**
     *Sletter en playlist
     * @param name
     * @throws SQLException
     */
    public void removePlaylist(String name) throws SQLException
    {
        pdb.removePlaylist(name);
    }
}
