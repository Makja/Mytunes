/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BE.Artist;
import BE.Category;
import BE.Song;
import BLL.SongManager;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class SongUpdateMenu extends Menu
{

    private static final int EXIT_VALUE = 0;
    private SongManager smgr;
    private Song s;
    private Artist a;
    private Category c;
    
    public SongUpdateMenu()
    {
        super("Update a song",
                "Update Title",
                "Update Artist",
                "Update Duration",
                "Update Category");
        EXIT_OPTION = EXIT_VALUE;
        try
        {
            smgr = new SongManager();
        }
        catch (Exception ex)
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
        }
    }

    private void updateTitle()
    {
        System.out.println();
        System.out.print("New Name: ");
        String title = new Scanner(System.in, "ISO-8859-1").nextLine();
        s.setTitle(title);
    }

    private void updateArtist()
    {
        System.out.println();
        System.out.print("New Artist: ");
        String name = new Scanner(System.in, "ISO-8859-1").nextLine();
        a.setArtistName(name);
    }

    private void updateDuration()
    {
        System.out.println();
        System.out.print("New Duration: ");
        int duration = new Scanner(System.in, "ISO-8859-1").nextInt();
        s.setDuration(duration);
    }

    private void updateCategory()
    {
        System.out.println();
        System.out.print("New Category: ");
        String category = new Scanner(System.in, "ISO-8859-1").nextLine();
        c.setCategoryName(category);
    }
}
