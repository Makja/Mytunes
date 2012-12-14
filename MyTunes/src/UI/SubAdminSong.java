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
 * @author Mak, Jonas og Daniel
 */
/**
 * Constructor, opretter en submenu med titlen "Song Menu" og 6 menuer, til at
 * liste, søge, tilføje/slette sange.
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
    /**
     * Giver mulighed for at vælge de forskellige menuer
     * @param option 
     */
    @Override
    protected void doAction(int option)
    {
        switch (option)
        {
            case 1:
                listAllSongs();         //lister alle sange op
                break;
            case 2:
                songSearch();           //søger en bestemt sang
                break;
            case 3:
                addSong();              //tilføjer en sang
                break;
            case 4:
                updateSong();
                break;
            case 5:
                removeSong();           //fjerner en sang
                break;
            case 6:
                checkSongs();
                break;
            case EXIT_VALUE:
                doActionExit();
        }
    }

    /**
     * Lists all the songs currently on the database.
     */
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

    /**
     * Searches a for a specific song with the given title og artist.
     */
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

    /**
     * Adds a new song to the database with the given values. Title Artist
     * Category Filename Duration
     */
    private void addSong()          //tilføjer en sang
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

    /**
     * Updates the values of a specific song with the given values
     */
    private void updateSong()
    {
        clear();
        System.out.println("Update Song:");
        System.out.println("");
        try
        {

            ArrayList<Song> songs = smgr.ListAll();


            printSongHeader();
            for (Song s : songs)
            {
                System.out.println(s);
            }

            System.out.print("Select song id: ");
            int id = new Scanner(System.in).nextInt();
            Song song = null;
            for (Song s : songs)
            {
                if (s.getId() == id)
                {
                    song = s;
                }
            }
            if (song != null)
            {
                new SongUpdateMenu(song).run();
            }
            else
            {
                System.out.println("Unknown song Id");
                pause();
            }


        }
        catch (Exception e)
        {
//            System.out.println(" ERROR - " + e.getMessage());
            e.printStackTrace();

        }

    }

    /**
     * Deletes all the songs with the given Title
     */
    private void removeSong()
    {
        clear();
        System.out.println("Remove song:");
        System.out.println("");
        try
        {

            ArrayList<Song> songs = smgr.ListAll();


            printSongHeader();
            for (Song s : songs)
            {
                System.out.println(s);
            }

            System.out.print("Select song title: ");
            String title = new Scanner(System.in).nextLine();

            smgr.RemoveSong(title);
        }
        catch (Exception ex)
        {
            System.out.println(" ERROR - " + ex.getMessage());
            pause();
        }
    }

    /**
     * Not implemented yet.
     */
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
