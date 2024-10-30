package tui;
import java.util.Scanner;
import model.Friend;
import model.LP;
import controller.FriendController;
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
    

    /**
     * Constructor for objects of class MainMenu
     */
    public MainMenu() {
        // initialise instance variables
        loanMenu = new LoanMenu();
        
       
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
                  System.out.println("Denne er ikke implementeret endnu");
                  break;
                case 2: // LP menu
                  System.out.println("Denne er ikke implementeret endnu");
                  break;
                case 3: // Udlånsmenu
                  loanMenu.start();
                  break;
                case 4:
                    System.out.println("Opret en ven");
                    createFriend();
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
        System.out.println(" (1) Lånermenu");
        System.out.println(" (2) LP menu");
        System.out.println(" (3) Udlånsmenu");
        System.out.println(" (4) Opret Ven");
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
    
    private void createFriend(){
        String name = inputFriendName();
        String address = inputFriendAddress();
        String postalCode = inputFriendPostalCode();
        String city = inputFriendCity();
        String phone = inputFriendPhone();
        FriendController controller = new FriendController();
        Friend friend = controller.createFriend(name, address, postalCode,city, phone);
        System.out.println("Ven lavet: " + friend.getName());
    }
    private String inputFriendName() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast navnet på din ven:  ");
        String name = keyboard.nextLine();
        return name;
    }
    private String inputFriendAddress() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast addressen på din ven:  ");
        String address = keyboard.nextLine();
        return address;
    }
    private String inputFriendPostalCode() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast postnummeret på din ven:  ");
        String postalCode = keyboard.nextLine();
        return postalCode;
    }
    private String inputFriendCity() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast byen din ven bor i:  ");
        String city = keyboard.nextLine();
        return city;
    }
    private String inputFriendPhone() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast din vens telefonnummer:  ");
        String phone = keyboard.nextLine();
        return phone;
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
