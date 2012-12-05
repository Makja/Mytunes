/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 *
 * @author Daniel
 */
public class SongUpdateMenu extends Menu
{

    private static final int EXIT_VALUE = 0;

    public SongUpdateMenu()
    {
        super("Update a song",
                "Update Title",
                "Update Artist",
                "Update Duration",
                "Update Category");
        EXIT_OPTION = EXIT_VALUE;
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
        System.out.println("You are trying to update the song title");
        pause();
    }

    private void updateArtist()
    {
        System.out.println("You are trying to update the song artist");
        pause();
    }

    private void updateDuration()
    {
        System.out.println("You are trying to update the song duration");
        pause();
    }

    private void updateCategory()
    {
        System.out.println("You are trying to update the song genre");
        pause();
    }
}
