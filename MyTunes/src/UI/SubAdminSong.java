/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BE.Song;
import BLL.MyTunesManager;
import DAL.MyTunesDBManager;
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
                doActionSuboption1();
                break;
            case 2:
                Search();
                break;
            case 3:
                doActionSuboption3();
                break;
            case 4:
                doActionSuboption4();
                break;
            case 5:
                doActionSuboption5();
                break;
            case 6:
                doActionSuboption6();
                break;
            case EXIT_VALUE:
                doActionExit();
        }
    }

    private void doActionSuboption1()
    {
        System.out.println("List of all songs");
        pause();
    }

    private void Search()
    {

        try
        {   
            ArrayList<Song> songs = mgr.Search();


           
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

    private void doActionSuboption3()
    {
        System.out.println("You are adding a song");
        pause();
    }

    private void doActionSuboption4()
    {
        System.out.println("You are trying to update a song");
        pause();
    }

    private void doActionSuboption5()
    {
        System.out.println("You are trying to delete a song");
        pause();
    }

    private void doActionSuboption6()
    {
        System.out.println("You are checking whether all the songs in the database exists");
        pause();
    }

    private void doActionExit()
    {
        System.out.println("returning to Administration Menu");        
    }
}
