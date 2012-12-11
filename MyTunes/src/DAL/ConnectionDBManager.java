/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Mak
 */
public class ConnectionDBManager
{
    protected SQLServerDataSource dataSource;
    
    public ConnectionDBManager() throws IOException
    {
        dataSource = new SQLServerDataSource();
        
        Properties props = new Properties();
        props.load(new FileReader("MyTunes.cfg"));

        dataSource.setServerName(props.getProperty("SERVER"));
        dataSource.setPortNumber(Integer.parseInt(props.getProperty("PORT")));
        dataSource.setDatabaseName(props.getProperty("DATABASE"));
        dataSource.setUser(props.getProperty("USER"));
        dataSource.setPassword(props.getProperty("PASSWORD"));
    }
}
