/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.util.logging.Level;
import java.util.logging.Logger;
import playerproject.MyTunesPlayer;

/**
 *
 * @author Stefan, Mak, Jonas og Daniel
 */
public class SubMenuCon extends Menu {

    private MyTunesPlayer p;
    private static final int EXIT_VALUE = 0;

    public SubMenuCon() {
        super("Submenu Control",
                "Play song",
                "Play playlist",
                "Stop",
                "Pause",
                "Resume",
                "Whats playing");
        EXIT_OPTION = EXIT_VALUE;
    }

    @Override
    protected void doAction(int option) {
        switch (option) {
            case 1:
                try {
                    playASong();
                } catch (Exception ex) {
                    Logger.getLogger(SubMenuCon.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 2:
                playAPlaylist();
                break;
            case 3:
                stopPlaying();
                break;

            case 4:
                pausePlayback();
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

    private void playASong() throws Exception {
        p = new MyTunesPlayer("01-bryan_adams_-_tonight_we_have_the_stars.mp3");
        p.play();
        System.out.println("You select Play");

    }

    private void playAPlaylist() {
        System.out.println("You select Play list");

    }

    private void stopPlaying() {
        p.stop();
        System.out.println("You tried to stop the playback");

    }

    private void pausePlayback() {
        p.pause();
        System.out.println("You tried to pause the playback");

    }

    private void resumePlayback() {
        p.resume();
        System.out.println("You tried to resume playing the current song");

    }

    private void isPlaying() {
        System.out.println("The current song playing is: [Not implemented yet]");

    }

    private void doActionExit() {
        System.out.println("Returning to MyTunes");
    }
}
