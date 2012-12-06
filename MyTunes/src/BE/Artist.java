/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

/**
 *
 * @author Daniel,Mak og Jonas
 */
public class Artist
{
    private final int artistId;
    private String artistName;
    
    public Artist(int artistId, String artistName)
    {
        this.artistId = artistId;
        this.artistName = artistName;
        
    }
    
    public int getArtisId()
    {
        return getArtistId();
    }
    
    public String getArtistName()
    {
        return artistName;
    }

    /**
     * @return the artistId
     */
    public int getArtistId()
    {
        return artistId;
    }

    /**
     * @param artistName the artistName to set
     */
    public void setArtistName(String artistName)
    {
        this.artistName = artistName;
    }
}
