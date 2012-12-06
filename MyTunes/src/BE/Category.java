/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

/**
 *
 * @author Daniel
 */
public class Category
{
    private final int categoryId;
    private String categoryName;
    
    
    public Category(int categoryId,String categoryName)
    {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        
    }

    /**
     * @return the categoryId
     */
    public int getCategoryId()
    {
        return categoryId;
    }

    /**
     * @return the categoryName
     */
    public String getCategoryName()
    {
        return categoryName;
    }

    /**
     * @param categoryName the categoryName to set
     */
    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }
}
