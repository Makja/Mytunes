/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 *
 * @author bhp
 */
public class SubMenuCon extends Menu
{
    private static final int EXIT_VALUE = 0;
    
    public SubMenuCon()
    {
        super("Submenu Control", "Play", "Play control");
        EXIT_OPTION = EXIT_VALUE;
    }

    @Override
    protected void doAction(int option)
    {
        switch (option)
        {
            case 1:
                doActionSuboption1();
                break;
            case 2:
                doActionSuboption2();
                break;
            case EXIT_VALUE: doActionExit();
        }
    }

    private void doActionSuboption1()
    {
        System.out.println("You select Play");
        pause();
    }

    private void doActionSuboption2()
    {
        System.out.println("You select Play list");
        pause();
    }

    private void doActionExit()
    {
        System.out.println("You selected to exit.");
        System.out.println("returned to");
        pause();
    }
}
