/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Mak, Daniel & Jonas
 */
public class PlayList
{

    private final int playlistId;
    private String playlistName;
    private Calendar created;

    /**
     *Første constructor
     * @param playlistId
     * @param playlistName
     * @param created
     */
    public PlayList(int playlistId, String playlistName, Calendar created)
    {
        this.playlistId = playlistId;
        this.playlistName = playlistName;
        this.created = created;
    }
    
    /**
     *Anden Constructor
     * @param playlistId
     * @param p
     */
    public PlayList(int playlistId, PlayList p)
    {
        this(playlistId, p.getName(), p.getCreated());
    }
    
    /**
     *Tredje constructor
     * @param playlistName
     * @param created
     */
    public PlayList(String playlistName, Calendar created)
    {
        this(-1, playlistName, created);
    }

    /**
     * returnerer playlist id
     * @return the id
     */
    public int getId()
    {
        return playlistId;
    }

    /**
     * returnerer playlist navn
     * @return the name
     */
    public String getName()
    {
        return playlistName;
    }

    /**
     * Sætter playlist navn
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.playlistName = name;
    }

    /**
     * returnerer playlist calender
     * @return the created
     */
    public Calendar getCreated()
    {
        return created;
    }

    /**
     * Sætter playlist calender
     * @param created the created to set
     */
    public void setCreated(Calendar created)
    {
        this.created = created;
    }
    
     @Override
    public String toString()
    {
        return String.format("%-5d %-30s %-30s ", playlistId, playlistName, created.getTime());
    }
}
