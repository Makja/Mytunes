/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 *
 * @author Stefan, Mak, Jonas og Daniel
 */
public class SubMenuCon extends Menu
{

    private static final int EXIT_VALUE = 0;

    public SubMenuCon()
    {
        super("Submenu Control", "Play song", "Play playlist", "Stop", "Pause", "Resume", "Whats playing");
        EXIT_OPTION = EXIT_VALUE;
    }

    @Override
    protected void doAction(int option)
    {
        switch (option)
        {
            case 1:
                playASong();
                break;
            case 2:
                playAPlaylist();
                break;
            case 3:
                stopPlaying();
                break;
            case 4:
                pausePlayblack();
                break;
            case 5:
                resumePlayback();
                break;
            case 6:
                isPlaying();
                break;
            case EXIT_VALUE:
                doActionExit();
        }
    }

    private void playASong()
    {
        System.out.println("You select Play");
        pause();
    }

    private void playAPlaylist()
    {
        System.out.println("You select Play list");
        pause();
    }

    private void stopPlaying()
    {
        System.out.println("You tried to stop the playback");
        pause();
    }

    private void pausePlayblack()
    {
        System.out.println("You tried to pause the playback");
        pause();
    }

    private void resumePlayback()
    {
        System.out.println("You tried to resume playing the current song");
        pause();
    }

    private void isPlaying()
    {
        System.out.println("The current song playing is: [Not implemented yet]");
        pause();
    }

    private void doActionExit()
    {
        System.out.println("Returning to MyTunes");
    }
}
