/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

/**
 *
 * @author Mak, Daniel & Jonas
 */
public class Category
{

    private final int categoryId;
    private String categoryName;

    /**
     *Første constructor
     * @param categoryId
     * @param categoryName
     */
    public Category(int categoryId, String categoryName)
    {
        this.categoryId = categoryId;
        this.categoryName = categoryName;

    }

    /**
     *Anden constructor
     * @param categoryName
     */
    public Category(String categoryName)
    {
        this(-1, categoryName);
    }


    /**
     * returnerer category id
     * @return the categoryId
     */
    public int getCategoryId()
    {
        return categoryId;
    }

    /**
     * returnerer category navn
     * @return the categoryName
     */
    public String getCategoryName()
    {
        return categoryName;
    }

    /**
     * sætter category navn
     * @param categoryName the categoryName to set
     */
    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }

    @Override
    public String toString()
    {
        return String.format(" %-10s", categoryName);
    }
}
