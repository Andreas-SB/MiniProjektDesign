package tui;
import java.util.Scanner;
import model.LP;
import controller.LPController;

/**
 * Write a description of class MainMenu here.
 *
 * @author Mogens Holm Iversen
 * @version 0.1.0 Initial draft version 
 */
public class MainMenu {
    // instance variables 
    private LoanMenu loanMenu;
    private FriendMenu friendMenu;
    private LPMenu lpMenu;

    /**
     * Constructor for objects of class MainMenu
     */
    public MainMenu() {
        // initialise instance variables
        loanMenu = new LoanMenu();
        friendMenu = new FriendMenu();
        lpMenu = new LPMenu();
       
    }
    
    public void start() {
        mainMenu();
    }
    
    private void mainMenu() {
        boolean running = true;
        while (running) {
            int choice = writeMainMenu();
            switch (choice) {
                case 1: // Lånermenu
                  System.out.println("Ven menu");
                  friendMenu.start();
                  break;
                case 2: // LP menu
                  System.out.println("LP menu");
                  lpMenu.start();
                  break;
                case 3: // Udlånsmenu
                  loanMenu.start();
                  break;
                case 9: // Generer testdata
                  System.out.println("Denne er ikke implementeret endnu");
                  createTestData();
                  break;
                case 0: // Afslut programmet
                  System.out.println("Tak for denne gang.");
                  running = false;
                  break;
                default:
                  System.out.println("Der er sket en uforklarlig fejl, choice = "+choice);
                  break;
            }
        }
    }

    private int writeMainMenu() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("****** Hovedmenu ******");
        System.out.println(" (1) Ven menu");
        System.out.println(" (2) LP menu");
        System.out.println(" (3) Udlånsmenu");
        System.out.println(" (9) Generer testdata");// will generate testdata, delete in final version
        System.out.println(" (0) Afslut programmet");
        System.out.print("\n Vælg:");
        
        while (!keyboard.hasNextInt()) {
            System.out.println("Input skal være et tal - prøv igen");
            keyboard.nextLine();
        }
        int choice = keyboard.nextInt();
        return choice;
    }
    
    private void createLP(){
        String barcode = inputLPBarcode();
        String title = inputLPTitle();
        String artist = inputLPArtist();
        String publicationDate = inputLPPublicationDate();
        LPController controller = new LPController();
        LP lp = controller.createLP(barcode, title, artist, publicationDate);
        System.out.println("LP lavet: " + lp.getTitle());
    }
    private String inputLPBarcode() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast navnet på din ven:  ");
        String barcode = keyboard.nextLine();
        return barcode;
    }
    private String inputLPTitle() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast navnet på din ven:  ");
        String title = keyboard.nextLine();
        return title;
    }
    private String inputLPArtist() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast navnet på din ven:  ");
        String artist = keyboard.nextLine();
        return artist;
    }
    private String inputLPPublicationDate() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast navnet på din ven:  ");
        String publicationDate = keyboard.nextLine();
        return publicationDate;
    }
    private void createTestData(){
        //getInstance
        //create some Friends and LPs
        
    }
}
