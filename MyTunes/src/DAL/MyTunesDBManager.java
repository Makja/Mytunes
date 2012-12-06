///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package DAL;
//
//import BE.Artist;
//import BE.Song;
//import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
//import java.io.FileReader;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.Properties;
//import java.util.Scanner;
//
///**
// *
// * @author Daniel
// */
//public class MyTunesDBManager
//{
//
//    private SQLServerDataSource dataSource;
//
//    public MyTunesDBManager() throws Exception
//    {
//        Properties props = new Properties();
//        props.load(new FileReader("MyTunes.cfg"));
//
//        dataSource = new SQLServerDataSource();
//
//        dataSource.setServerName(props.getProperty("SERVER"));
//        dataSource.setPortNumber(Integer.parseInt(props.getProperty("PORT")));
//        dataSource.setDatabaseName(props.getProperty("DATABASE"));
//        dataSource.setUser(props.getProperty("USER"));
//        dataSource.setPassword(props.getProperty("PASSWORD"));
//    }
//
//
//
//    /**
//     *
//     * @return @throws SQLException
//     */
//
//
//}
////    
////    public Song AddArtist(Song s) throws SQLException
////    {
////        String sql = 'INSERT INTO Artist VALUES(?) LIKE
////    }
////}
//
