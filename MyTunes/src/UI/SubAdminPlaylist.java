/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BE.PlayList;
import BE.Song;
import BLL.PlaylistManager;
import BLL.SongManager;
import java.util.ArrayList;

/**
 *
 * @author Mak, Jonas og Daniel
 */
/**
     * Constructor, opretter en submenu med titlen "Playlist menu" og 
     * 7 menu punkter, til at styrer playlisterne.
     */
public class SubAdminPlaylist extends Menu
{

    private static final int EXIT_VALUE = 0;
     private PlaylistManager pmgr;

    public SubAdminPlaylist()
    {
        super("Playlist Menu",          //Menuens title
                "List all Playlist",
                "Show all songs in a playlist",
                "Add a Playlist",
                "Remove a Playlist",
                "Re-order a Playlist",
                "Add a song to a Playlist",
                "Remove a song from a Playlist");
        EXIT_OPTION = EXIT_VALUE;
    }

    @Override
    protected void doAction(int option)
    {
        switch (option)
        {
            case 1:                     //Menupunkt til at vise alle playlister
                listAllPlaylists();
                break;
            case 2:
                listSongsInAPlaylist();
                break;
            case 3:
                AddAPlaylist();         //adder en ny playlist
                break;
            case 4:
                removePlaylist();
                break;
            case 5:
                reOrderPlaylist();
                break;
            case 6:
                addSongToPlaylist();     //tilføjer sang til en playliste
                break;
            case 7:
                removeSongFromPlaylist();
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
            System.out.println(" ERROR - " + e.getMessage());
        }
        pause();
    }

    private void listSongsInAPlaylist()
    {
        System.out.println("Showing all songs in a playlist");
        pause();
    }

    private void AddAPlaylist()
    {
        System.out.println("Adding a playlist");
        pause();
    }

    private void removePlaylist()
    {
        System.out.println("Removing a playlist");
        pause();
    }

    private void reOrderPlaylist()
    {
        System.out.println("You are trying to re-order a playlist");
        pause();
    }

    private void addSongToPlaylist()
    {
        System.out.println("You are trying to add a song to a playlist");
        pause();
    }

    private void removeSongFromPlaylist()
    {
        System.out.println("You are trying to remove a song from a playlist.");
        pause();
    }

    private void doActionExit()
    {
        System.out.println("Returning to Administration Menu");     
    }
}
