/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

/**
 *
 * @author Mak
 */
public class Song
{

    private final int id;
    private String title;
    private Artist artist;
    private Category category;
    private String fileName;
    private int duration;

    /**
     *
     * @param id
     * @param title
     * @param artist
     * @param category
     * @param fileName
     * @param duration
     */ 
    public Song(String title, Artist artist, Category category, String fileName, int duration)
    {
        this(-1, title, artist, category, fileName, duration);
    }
    
    public Song(int id, String title, Artist artist, Category category, String fileName, int duration)
    {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.category = category;
        this.fileName = fileName;
        this.duration = duration;
    }
   
    public Song(int id, Song s)
    {
        this(id, s.getTitle(), s.getArtist(), s.getCategory(), s.getFileName(), s.getDuration());
    }

    /**
     *
     * @param id
     * @param title
     */
    /**
     * @return the id
     */
    public int getId()
    {
        return id;
    }

    /**
     * @return the title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * @return the artist
     */
    public Artist getArtist()
    {
        return artist;
    }

    /**
     * @param artist the artist to set
     */
    public void setArtist(Artist artist)
    {
        this.artist = artist;
    }

    /**
     * @return the category
     */
    public Category getCategory()
    {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Category category)
    {
        this.category = category;
    }

    /**
     * @return the fileName
     */
    public String getFileName()
    {
        return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    /**
     * @return the duration
     */
    public int getDuration()
    {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(int duration)
    {
        this.duration = duration;
    }
    

    @Override
    public String toString()
    {
        return String.format("%-5d %-30s %-30s %-10s %-20s %5d", id, title, artist, category, fileName, duration);
    }
}
