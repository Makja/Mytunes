/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BE.Song;
import BLL.MyTunesManager;
import java.util.ArrayList;

/**
 *
 * @author Stefan, Mak, Jonas og Daniel
 */
public class SubAdminSong extends Menu
{

    private static final int EXIT_VALUE = 0;
    private MyTunesManager mgr;

    public SubAdminSong()
    {
        super("Song Menu",
                "List All",
                "Search",
                "Add Song",
                "Update a Song",
                "Remove a Song",
                "Check");
        EXIT_OPTION = EXIT_VALUE;
        try
        {
            mgr = new MyTunesManager();
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
                listAllSongs();
                break;
            case 2:
                songSearch();
                break;
            case 3:
                addSong();
                break;
            case 4:
                updateSong();
                break;
            case 5:
                removeSong();
                break;
            case 6:
                checkSongs();
                break;
            case EXIT_VALUE:
                doActionExit();
        }
    }

    private void listAllSongs()
    {
        System.out.println("List of all songs");
        pause();
    }

    private void songSearch()
    {
        clear();
        try
        {   
            ArrayList<Song> songs = mgr.Search();


           printSongHeader();
            for (Song s : songs)
            {
                System.out.println(s);
            }
        }
        catch (Exception e)
        {
            System.out.println(" ERROR - " + e.getMessage());
        }
        pause();
    }

    private void addSong()
    {
        System.out.println("You are adding a song");
        pause();
    }

    private void updateSong()
    {
        System.out.println("You are trying to update a song");
        pause();
    }

    private void removeSong()
    {
        System.out.println("You are trying to delete a song");
        pause();
    }

    private void checkSongs()
    {
        System.out.println("You are checking whether all the songs in the database exists");
        pause();
    }

    private void doActionExit()
    {
        System.out.println("returning to Administration Menu");        
    }
}
