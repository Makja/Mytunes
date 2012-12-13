/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BE.PlayList;
import BLL.ArtistManager;
import BLL.CategoryManager;
import BLL.PlaylistManager;
import BLL.SongManager;
import java.util.ArrayList;

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
    private PlaylistManager pmgr;

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
            pmgr = new PlaylistManager();
            
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
                listAllPlaylists();     //lister alle playlister op menu
                break;
            case 2:
                allSongPlaylist();      //viser alle sange på playliste menu
                break;
            case 3:
                addPlaylist();          //tilføj en play liste menu
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
         try
        {
            ArrayList<PlayList> playlists = pmgr.getAllPlaylists();

            clear();
            printSongHeader2();

            for (PlayList p : playlists)
            {
                System.out.println(p);
            }
        }
        catch (Exception e)
        {
//            System.out.println(" ERROR - " + e.getMessage());
            e.printStackTrace();
        }
        pause();
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
