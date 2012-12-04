/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 *
 * @author Stefan, Mak, Jonas og Daniel
 */
public class SubAdminPlaylist extends Menu
{

    private static final int EXIT_VALUE = 0;

    public SubAdminPlaylist()
    {
        super("Playlist Menu",
                "List all Playlist",
                "Show all songs in a playlist",
                "Add a Playlist",
                "Remove a Playlist",
                "Re-order a Playlist",
                "Add a song to a Playlist",
                "Remove a song from a Playlist");
        EXIT_OPTION = EXIT_VALUE;
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
                doActionSuboption2();
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
            case 7:
                doActionSuboption7();
            case EXIT_VALUE:
                doActionExit();
        }
    }

    private void doActionSuboption1()
    {
        System.out.println("Printing all playlists");

        pause();
    }

    private void doActionSuboption2()
    {
        System.out.println("Showing all songs in a playlist");
        pause();
    }

    private void doActionSuboption3()
    {
        System.out.println("Adding a playlist");
        pause();
    }

    private void doActionSuboption4()
    {
        System.out.println("Removing a playlist");
        pause();
    }

    private void doActionSuboption5()
    {
        System.out.println("You are trying to re-order a playlist");
        pause();
    }

    private void doActionSuboption6()
    {
        System.out.println("You are trying to add a song to a playlist");
        pause();
    }

    private void doActionSuboption7()
    {
        System.out.println("You are trying to remove a song from a playlist.");
        pause();
    }

    private void doActionExit()
    {
        System.out.println("You selected to exit.");
        System.out.println("Bye Bye...");
        pause();
    }
}
