/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 *Hovedmenuen
 * @author Stefan, Mak, Jonas og Daniel
 */
public class MainMenu extends Menu
{

    private static final int EXIT_VALUE = 0;
    
    /**
     * Constructor, opretter en hovedmenu med titlen "MyTunes" og 
     * to menupunkter administration og control
     */
    public MainMenu()
    {
        super("MyTunes", "Administration",
                "Control");
                EXIT_OPTION = EXIT_VALUE;
    }

    @Override
    protected void doAction(int option)
    {
        switch (option)
        {
            case 1:
                goToAdminMenu();
                break;
            case 2:
                goToControlMenu();
                break;
        }
    }

    private void goToAdminMenu()
    {
        new SubMenuAdmin().run();
    }

    private void goToControlMenu()
    {
        System.out.println("You selected Control");
        new SubMenuCon().run();
    }

}
