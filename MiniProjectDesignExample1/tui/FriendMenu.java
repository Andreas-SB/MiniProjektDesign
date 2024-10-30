package tui;
import java.util.Scanner;


public class FriendMenu
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class FriendMenu
     */
    public FriendMenu()
    {
        // initialise instance variables

    }

    public void start() {
        friendMenu();
    }

    private void friendMenu() {
        boolean running = true;
        while (running) {
            int choice = writeFriendMenu();
            switch (choice) {
                case 1:
                    System.out.println(" (1) Opret ven");
                    break;
                case 2: 
                    System.out.println(" (2) Søg efter telefonnummer");
                    break;
                case 0:
                    System.out.println(" (0) Tilbage");
                    running = false;
                    break;
                default:
                    System.out.println("En uforklarlig fejl er sket med choice = " + choice);
                    break;
            }
        }
    }

    private int writeFriendMenu() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("****** Venne menu  ******");
        System.out.println(" (1) Opret ven");
        System.out.println(" (2) Søg efter telefonnummer");
        System.out.println(" (0) Tilbage");
        System.out.print("\n Vælg:");
        int choice = getIntegerFromUser(keyboard);
        return choice;
    }

    private int getIntegerFromUser(Scanner keyboard) {
        while (!keyboard.hasNextInt()) {
            System.out.println("Input skal være et tal - prøv igen");
            keyboard.nextLine();
        }
        return keyboard.nextInt();
    }

}
