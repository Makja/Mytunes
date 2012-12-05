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
    
    /**
     *  Opretter en submenu med titlen "Administration Menu" og to menu punkter,
     *  "Song" og "Playlist"
     */
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
        new SubAdminSong().run();
        clear();
    }

    private void goToPlaylistAdmin()
    {
        new SubAdminPlaylist().run();
        clear();
    }

    private void doActionExit()
    {
        System.out.println("Returning to MyTunes");        
        pause();
    }
}
