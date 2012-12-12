/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BLL.ArtistManager;
import BLL.CategoryManager;
import BLL.SongManager;

/**
 *
 * @author Mak, Jonas og Daniel
 */
public class SubPlaylistMenu extends Menu
{

    private static final int EXIT_VALUE = 0;
    private SongManager smgr;
    private ArtistManager amgr;
    private CategoryManager cmgr;

    public SubPlaylistMenu()
    {
        super("Playlist Menu",
                "List All",
                "All song on a playlist",
                "Add playlist",
                "Remove a playlist",
                "Reorder playlist",
                "Add a song to a playlist",
                "Remove a song from playlist");
        EXIT_OPTION = EXIT_VALUE;
        try
        {
            smgr = new SongManager();
            amgr = new ArtistManager();
            cmgr = new CategoryManager();
            
        }
        catch (Exception ex)
        {
            System.out.println("ERROR - " + ex.getMessage());
            System.exit(2);
        }
    }

    @Override
    protected void doAction(int option)
    {
        switch (option)
        {
            case 1:
                listAllPlaylists();
                break;
            case 2:
                allSongPlaylist();
                break;
            case 3:
                addPlaylist();
                break;
            case 4:
                removePlaylist();
                break;
            case 5:
                ReorderPlaylist();
                break;
            case 6:
                addSongPlaylist();
                break;
            case 7:
                removeSongPlaylist();
                break;
            case EXIT_VALUE:
                doActionExit();
        }
    }

    private void listAllPlaylists()
    {
        System.out.println("You are listing all Playlist");
    }

    private void allSongPlaylist()
    {
        System.out.println("All songs on the Playlist");
    }

    private void addPlaylist()
    {
        System.out.println("You are adding a playlist");        
    }

    private void removePlaylist()
    {
        System.out.println("You are removing a playlist");
    }

    private void ReorderPlaylist()
    {
        System.out.println("You are reordering a playlist");
    }

    private void addSongPlaylist()
    {
        System.out.println("You are adding a song to a playlist");        
    }
    
    private void removeSongPlaylist()
    {
        System.out.println("You are removing a song to a playlist");        
    }

    private void doActionExit()
    {
        System.out.println("returning to Menu");
    }
}
