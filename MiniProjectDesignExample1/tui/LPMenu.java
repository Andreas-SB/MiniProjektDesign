package tui;
import java.util.Scanner;


public class LPMenu
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class FriendMenu
     */
    public LPMenu()
    {
        // initialise instance variables

    }

    public void start() {
        LPMenu();
    }

    private void LPMenu() {
        boolean running = true;
        while (running) {
            int choice = writeLPMenu();
            switch (choice) {
                case 1:
                    System.out.println(" (1) Opret LP");
                    break;
                case 2: 
                    System.out.println(" (2) Opret LP kopi");
                    break;
                case 3: 
                    System.out.println(" (3) Søg LP");
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

    private int writeLPMenu() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("****** LP menu  ******");
        System.out.println(" (1) Opret LP");
        System.out.println(" (2) Opret LP kopi");
        System.out.println(" (3) Søg LP");
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

