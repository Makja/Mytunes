/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Category;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class CategoryDBManager extends ConnectionDBManager
{

    
    
    public CategoryDBManager() throws IOException
    {
       
    }
    
    public Category addCategory(Category category) throws SQLException
       {
        String sql = "INSERT INTO Category VALUES (?)";
        Connection con = dataSource.getConnection();

        PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ps.setString(1, category.getCategoryName());

        int affectedRows = ps.executeUpdate();
        if (affectedRows == 0)
        {
            throw new SQLException("Unable to insert Category");
        }

        ResultSet keys = ps.getGeneratedKeys();
        keys.next();
        int id = keys.getInt(1);
        
        return new Category(id, category.getCategoryName());

    }
    
    public Category getCategoryName(String name) throws SQLException
    {
        try (Connection con = dataSource.getConnection())
        {
            
            String sql = ("SELECT * FROM Category WHERE Name Like ?");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);


            ResultSet rs = ps.executeQuery();

            if (rs.next())
            {
                String categoryName = rs.getString("Category");

                Category c = new Category(categoryName);
                return c;
            }
            return null;
        }

    }
    public ArrayList<Category> getAllCategories()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public Category getCategoryById()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
