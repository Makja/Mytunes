/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Category;
import DAL.CategoryDBManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Daniel, Jonas, Mak
 */
public class CategoryManager
{

    private CategoryDBManager cdb = null;

    /**
     *Constructor
     * @throws IOException
     */
    public CategoryManager() throws IOException
    {
        cdb = new CategoryDBManager();
    }

    /**
     *Henter alle kategorier
     * @return
     */
    public ArrayList<Category> getAllCategories()
    {
        return cdb.getAllCategories();
    }
    
    /**
     *Henter kategorier via id
     * @return
     */
    public Category getCategoryById()
    {
        return cdb.getCategoryById();
    }
    
    /**
     *Henter kategorier via navn
     * @param categoryName
     * @return
     * @throws SQLException
     */
    public Category getCategoryByName(String categoryName) throws SQLException
    {
        return cdb.getCategoryName(categoryName);
    }
    
    /**
     *Tilføjer kategori
     * @param category
     * @return
     * @throws SQLException
     */
    public Category addCategory(Category category) throws SQLException
    {
        return cdb.addCategory(category);
    }
}
