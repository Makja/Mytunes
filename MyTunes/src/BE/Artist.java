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
    
    /**
     *Første constructor
     * @param artistId
     * @param artistName
     */
    public Artist(int artistId, String artistName)
    {
        this.artistId = artistId;
        this.artistName = artistName;
        
    }

    /**
     *Anden constructor
     * @param artistName
     */
    public Artist(String artistName)
    {
        this(-1, artistName);
    }
    
    /**
     *Tredje constructor
     * @param artistId
     * @param artist
     */
    public Artist(int artistId, Artist artist)
    {
        this(artistId, artist.getArtistName());
    }
//    public Artist(int artistId, Artist artist)
//    {
//        this(artistId, artist.getArtistName());
//    }
    
    /**
     *returnerer artist navnet
     * @return artistName
     */
    public String getArtistName()
    {
        return artistName;
    }

    /**returnerer artist id
     * @return the artistId
     */
    public int getArtistId()
    {
        return artistId;
    }

    /**Sætter artist navnet
     * @param artistName the artistName to set
     */
    public void setArtistName(String artistName)
    {
        this.artistName = artistName;
    }
    
    
     @Override
    public String toString()
    {
        return String.format("%-30s", artistName);
    }
}
