/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BE.Artist;
import BE.Category;
import BE.Song;
import BLL.SongManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Mak, Daniel & Jonas
 */
public class SongUpdateMenu extends Menu
{

    private static final int EXIT_VALUE = 0;
    private Song s;
    private Artist a;
    private Category c;


    public SongUpdateMenu(Song song) throws SQLException, IOException
    {
        super("Update a song",
                "Update Title",
                "Update Artist",
                "Update Duration",
                "Update Category");
        EXIT_OPTION = EXIT_VALUE;
     s = song;
   
 
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
        c.setCategoryName(category);
    }

    /*
     * Saves the changes to the database.
     * (Called on exit)
     */
    private void saveChanges()
    {
        try
        {
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
