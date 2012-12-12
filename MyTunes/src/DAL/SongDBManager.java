package DAL;

import BE.Artist;
import BE.Category;
import BE.Song;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class SongDBManager extends ConnectionDBManager
{

    public SongDBManager() throws IOException
    {
    }

    public ArrayList<Song> Search() throws SQLException
    {
        try (Connection con = dataSource.getConnection())
        {
            Scanner sc = new Scanner(System.in, "ISO-8859-1");
            System.out.println("Indtast Søgeord");
            String searchString = sc.nextLine();
            String sql = "SELECT * FROM artist JOIN Song ON artist.id = Song.artistID JOIN Category ON Category.id = Song.categoryID"
                    + " WHERE artist.Name LIKE ? OR Song.title LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, searchString);
            ps.setString(2, searchString);

            ResultSet rs = ps.executeQuery();

            ArrayList<Song> songs = new ArrayList<>();

            while (rs.next())
            {
                int id = rs.getInt("ID");
                String title = rs.getString("Title");
                String artistName = rs.getString("Name");
                String categoryName = rs.getString("Category");
                String fileName = rs.getString("Filename");
                int duration = rs.getInt("Duration");

                Song s = new Song(id, title, new Artist(artistName), new Category(categoryName), fileName, duration);
                songs.add(s);
            }
            return songs;
        }


    }

    public ArrayList<Song> ListAll() throws SQLException
    {
        try (Connection con = dataSource.getConnection())
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT Song.*, Artist.Name, Category.Category FROM Song, Artist, Category WHERE Song.Artistid = artist.id AND Song.Categoryid = Category.id");

            ArrayList<Song> songs = new ArrayList<>();

            while (rs.next())
            {
                int id = rs.getInt("ID");
                String title = rs.getString("Title");
                String artistName = rs.getString("Name");
                String categoryName = rs.getString("Category");
                String fileName = rs.getString("Filename");
                int duration = rs.getInt("Duration");

                Song s = new Song(id, title, new Artist(artistName), new Category(categoryName), fileName, duration);
                songs.add(s);
            }
            return songs;
        }

    }

    public Song AddSong(Song s) throws SQLException
    {


        Connection con = dataSource.getConnection();

        String sql = "INSERT INTO Song(Title, ArtistId, CategoryId, FileName, Duration)" + ""
                + "VALUES(?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ps.setString(1, s.getTitle());
        ps.setInt(2, s.getArtist().getArtistId());
        ps.setInt(3, s.getCategory().getCategoryId());
        ps.setString(4, s.getFileName());
        ps.setInt(5, s.getDuration());


        int affectedRows = ps.executeUpdate();
        if (affectedRows == 0)
        {
            throw new SQLException("Unable to add Song");
        }

        ResultSet keys = ps.getGeneratedKeys();
        keys.next();
        int id = keys.getInt(1);

        return new Song(id, s);
    }

//    public void updateSong(Song s) throws SQLException
//    {
//
//        String sql = "UPDATE Employee SET Name = ?, Address = ?, DepNum = ? WHERE Id = ?";
//
//        Connection con = dataSource.getConnection();
//
//        PreparedStatement ps = con.prepareStatement(sql);
//        ps.setString(1, s.getTitle());
//        ps.setString(2, s.());
//        ps.setInt(3, e.getDepNum());
//        ps.setInt(4, e.getId());
//
//        int affectedRows = ps.executeUpdate();
//        if (affectedRows == 0)
//        {
//            throw new SQLException("Unable to update Employee");
//        }
//
//    }
    public void RemoveSong(String title) throws SQLException
    {
        String sql = "DELETE FROM SONG WHERE Title = ?";

        Connection con = dataSource.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, title);

        int affectedRows = ps.executeUpdate();
        if (affectedRows == 0)
        {
            throw new SQLException("Unable to delete Song");
        }
    }
}
