/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Category;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    
    public Category getCategoryName(String categoryName) throws SQLException
    {
        try (Connection con = dataSource.getConnection())
        {
            
            String sql = ("SELECT * FROM Category WHERE Category Like ?");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, categoryName);


            ResultSet rs = ps.executeQuery();

            if (rs.next())
            {
                String name = rs.getString("Category");
                int Id = rs.getInt("ID");

                Category c = new Category(Id, name);
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
