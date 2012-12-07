/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Category;
import DAL.CategoryDBManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class CategoryManager
{

    private CategoryDBManager cdb = null;

    public CategoryManager()
    {
        cdb = new CategoryDBManager();
    }

    public ArrayList<Category> getAllCategories()
    {
        return cdb.getAllCategories();
    }
    
    public Category getCategoryById()
    {
        return cdb.getCategoryById();
    }
    
    public Category getCategoryByName(String categoryName) throws SQLException
    {
        return cdb.getCategoryName();
    }
    
    public Category addCategory(Category category) throws SQLException
    {
        return cdb.addCategory(category);
    }
}
