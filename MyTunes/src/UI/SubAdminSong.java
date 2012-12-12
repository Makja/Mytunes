/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BE.Artist;
import BE.Category;
import BE.Song;
import BLL.ArtistManager;
import BLL.CategoryManager;
import BLL.SongManager;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Stefan, Mak, Jonas og Daniel
 */
public class SubAdminSong extends Menu
{

    private static final int EXIT_VALUE = 0;
    private SongManager smgr;
    private ArtistManager amgr;
    private CategoryManager cmgr;

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
        try
        {
            ArrayList<Song> songs = smgr.ListAll();

            clear();
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

    private void songSearch()
    {
        clear();
        try
        {
            ArrayList<Song> songs = smgr.Search();

            clear();
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
        
        
        clear();
        System.out.println("Add Song:");
        System.out.println();

        try
        {
            Scanner sc = new Scanner(System.in, "ISO-8859-1");

            System.out.print("Title: ");
            String title = sc.nextLine();

            System.out.print("Artist: ");
            String artistName = sc.nextLine();

            System.out.print("Category: ");
            String categoryName = sc.nextLine();

            System.out.print("Filename: ");
            String fileName = sc.nextLine();

            System.out.print("Duration: ");
            int duration = sc.nextInt();

            Artist a = amgr.getArtistByName(artistName);
            
            if (a == null)
            {
                a = amgr.addArtist(new Artist(-1, artistName));
            }

            Category c = cmgr.getCategoryByName(categoryName);
            if (c == null)
            {
                c = cmgr.addCategory(new Category(-1, categoryName));
            }

            Song song = new Song(-1, title, a, c, fileName, duration);
            song = smgr.AddSong(song);

            System.out.println();
            System.out.println("Song added with ID : " + song.getId());
        }
        catch (InputMismatchException e)
        {
            System.out.println("ERROR - Duration must be number");
        }
        catch (Exception ex)
        {
            System.out.println("ERROR - " + ex.getMessage());
         
        }
        pause();
    }

    private void updateSong()
    {
        clear();
        new SongUpdateMenu().run();
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
