package DAL;

import BE.Artist;
import BE.Category;
import BE.Song;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
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
public class SongDBManager
{

    private SQLServerDataSource dataSource;

    public SongDBManager() throws IOException
    {

        Properties props = new Properties();
        props.load(new FileReader("MyTunes.cfg"));

        dataSource = new SQLServerDataSource();

        dataSource.setServerName(props.getProperty("SERVER"));
        dataSource.setPortNumber(Integer.parseInt(props.getProperty("PORT")));
        dataSource.setDatabaseName(props.getProperty("DATABASE"));
        dataSource.setUser(props.getProperty("USER"));
        dataSource.setPassword(props.getProperty("PASSWORD"));
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
                int id = rs.getInt("Id");
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
            ResultSet rs = st.executeQuery("SELECT * FROM artist JOIN Song ON artist.id = Song.artistID JOIN Category ON Category.id = Song.categoryID");

            ArrayList<Song> songs = new ArrayList<>();

            while (rs.next())
            {
                int id = rs.getInt("Id");
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

        String sql = "INSERT INTO Song(Title, FileName, Duration)" + ""
                + "VALUES(?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ps.setString(1, s.getTitle());
        ps.setString(2, s.getFileName());
        ps.setInt(3, s.getDuration());

        String sql2 = "INSERT INTO Artist(Name) VALUES(?)";
        PreparedStatement ps2 = con.prepareStatement(sql2, PreparedStatement.RETURN_GENERATED_KEYS);
        ps2.setString(1, s.getArtist().getArtistName());

        String sql3 = "INSERT INTO Category(Category) VALUES(?)";
        PreparedStatement ps3 = con.prepareStatement(sql3, PreparedStatement.RETURN_GENERATED_KEYS);
        ps3.setString(1, s.getCategory().getCategoryName());



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
   
    public Song updateSong(song s) throws SQLException
    {
       Connection con = dataSource.getConnection(); 
        return Song(id, s);
    }
}