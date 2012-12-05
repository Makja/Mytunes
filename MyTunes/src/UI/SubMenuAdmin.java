/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 *
 * @author Stefan, Mak, Jonas og Daniel
 */
public class SubMenuAdmin extends Menu
{
    private static final int EXIT_VALUE = 0;
    
    public SubMenuAdmin()
    {
        super("Administration Menu", 
                "Song", 
                "Playlist");
        EXIT_OPTION = EXIT_VALUE;
    }

    @Override
    protected void doAction(int option)
    {
        switch (option)
        {
            case 1:
                goToSongAdmin();
                break;
            case 2:
                goToPlaylistAdmin();
                break;
            case EXIT_VALUE: doActionExit();
        }
    }

    private void goToSongAdmin()
    {
        System.out.println("Song");
        
        pause();
        clear();
    }

    private void goToPlaylistAdmin()
    {
        System.out.println("Playlist");
        pause();
        clear();
    }

    private void doActionExit()
    {
        System.out.println("You selected to exit.");
        System.out.println("Bye Bye...");
        pause();
    }
}
