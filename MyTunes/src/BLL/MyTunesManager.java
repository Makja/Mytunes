/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Song;
import DAL.MyTunesDBManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Mak
 */
public class MyTunesManager
{

    private MyTunesDBManager db = null;

    public MyTunesManager() throws Exception
    {
        db = new MyTunesDBManager();
    }
    
    
    public ArrayList<Song> Search() throws SQLException
    {
        return db.Search();
    }
    
    public ArrayList<Song> ListAll() throws SQLException
    {
        return db.ListAll();
    }
}
