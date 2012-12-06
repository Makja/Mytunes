/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Category;
import DAL.CategoryDBManager;
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
        return cdb.getAllCategories;
    }
    
    public ArrayList<Category> getCategoryById()
    {
        return cdb.getCategoryById;
    }
    
    public ArrayList<Category> getCategoryByName()
    {
        return cdb.getCategoryByName;
    }
}
