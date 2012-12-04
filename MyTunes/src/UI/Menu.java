/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */

    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
public abstract class Menu
{

    protected int EXIT_OPTION = 0;
    private final String header;
    private final String[] menuItems;

    public Menu(String header, String... menuItems)
    {
        this.header = header;
        this.menuItems = menuItems;

    }

    public void run()
    {
        boolean done = false;
        while (!done)
        {
            showMenu();
            int option = getOption();
            doAction(option);
            if (option == EXIT_OPTION)
            {
                done = true;
            }
        }
    }

    private void showMenu()
    {
        clear();
        System.out.println("\n" + header.toUpperCase() + "\n");

        for (int i = 0; i < menuItems.length; i++)
        {
            System.out.println(String.format("%2d)  %s", (i + 1), menuItems[i]));
        }
        System.out.println(String.format("%2d)  %s", EXIT_OPTION, "Exit"));
    }

    private int getOption()
    {
        while (true)
        {

            try
            {
                System.out.println("\n Enter option:");
                int option = new Scanner(System.in).nextInt();
                if (option >= 1 && option <= menuItems.length || option == EXIT_OPTION)
                {
                    return option;
                }
                else
                {
                    System.out.println();
                    System.out.println("That option is not available, try again please.");
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("ERROR - That was not a number, try again please.");
            }
        }
    }

    protected void clear()
    {
        for (int i = 0; i < 50; i++)
        {
            System.out.println();
        }
    }
    
    protected void pause()
    {
        System.out.println("\nPress ENTER to continue...");
        new Scanner(System.in).nextLine();
    }

    abstract protected void doAction(int option);
}

