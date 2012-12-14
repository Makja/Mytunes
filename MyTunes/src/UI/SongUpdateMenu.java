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
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Mak, Daniel & Jonas
 */
public class SongUpdateMenu extends Menu
{

    private static final int EXIT_VALUE = 0;
    private Song s;
    private ArtistManager amgr;
    private CategoryManager cmgr;

    public SongUpdateMenu(Song song)
    {
        super("Update a song",
                "Update Title",
                "Update Artist",
                "Update Duration",
                "Update Category");
        EXIT_OPTION = EXIT_VALUE;
        s = song;
        try
        {
            amgr = new ArtistManager();
            cmgr = new CategoryManager();
        }
        catch (IOException ex)
        {
            System.out.println("ERROR - " + ex.getMessage());
        }


    }

    @Override
    protected void doAction(int option)
    {

        switch (option)
        {
            case 1:
                updateTitle();
                break;
            case 2:
                updateArtist();
                break;
            case 3:
                updateDuration();
                break;
            case 4:
                updateCategory();
                break;
            case EXIT_VALUE:
                doActionExit();


        }
    }

    /*
     * Updates the title to the given name.
     */
    private void updateTitle()
    {
        System.out.println();
        System.out.print("New Name: ");
        String title = new Scanner(System.in, "ISO-8859-1").nextLine();
        s.setTitle(title);
    }
    /*
     * Updates the artist to the given name.
     */

    private void updateArtist()
    {
        System.out.println();
        System.out.print("New Artist: ");
        String name = new Scanner(System.in, "ISO-8859-1").nextLine();
        s.getArtist().setArtistName(name);
    }

    /*
     * Updates the duration to the given lenght
     */
    private void updateDuration()
    {
        System.out.println();
        System.out.print("New Duration: ");
        int duration = new Scanner(System.in, "ISO-8859-1").nextInt();
        s.setDuration(duration);
    }

    /*
     * Updates the category of a song
     */
    private void updateCategory()
    {
        System.out.println();
        System.out.print("New Category: ");
        String category = new Scanner(System.in, "ISO-8859-1").nextLine();
        s.getCategory().setCategoryName(category);
    }

    /*
     * Saves the changes to the database.
     * (Called on exit)
     */
    private void saveChanges()
    {
        try
        {
            Artist a = amgr.getArtistByName(s.getArtist().getArtistName());
            if (a == null)
            {
                a = amgr.addArtist(new Artist(-1, s.getArtist().getArtistName()));
            }
            s.setArtist(a);
            
            Category c = cmgr.getCategoryByName(s.getCategory().getCategoryName());
            if (c == null)
            {
                c = cmgr.addCategory(new Category(-1, s.getCategory().getCategoryName()));
            }
            s.setCategory(c);
            
            SongManager smgr = new SongManager();
            smgr.updateSong(s);
            
        }
        catch (Exception e)
        {

            System.out.println("ERROR - " + e.getMessage());
            pause();
        }
    }

    /*
     * Exits and saves the changes you've made.
     */
    private void doActionExit()
    {
        saveChanges();
    }
}
