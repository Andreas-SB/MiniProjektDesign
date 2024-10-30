package tui;
import java.util.Scanner;
import model.LP;
import controller.LPController;

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
                    createLP();
                    break;
                case 2: 
                    System.out.println(" (2) Opret LP kopi");
                    break;
                case 3: 
                    System.out.println(" (3) Søg LP");
                    LP lp = findLP();
                     if (lp == null){
                        System.out.println("LP er ikke fundet");
                    }
                    else{
                        System.out.println("LP er fundet " + lp.getTitle());
                    }
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
    
    private LP findLP() {
        String title= inputLPTitle();
        LPController controller = new LPController();      
        LP lp = controller.findLP(title);
        return lp;
    }

    private int getIntegerFromUser(Scanner keyboard) {
        while (!keyboard.hasNextInt()) {
            System.out.println("Input skal være et tal - prøv igen");
            keyboard.nextLine();
        }
        return keyboard.nextInt();
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
        System.out.println(" Indtast stregekode på LP:  ");
        String barcode = keyboard.nextLine();
        return barcode;
    }
    private String inputLPTitle() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast Title på LP:  ");
        String title = keyboard.nextLine();
        return title;
    }
    private String inputLPArtist() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast Kunstner på LP:  ");
        String artist = keyboard.nextLine();
        return artist;
    }
    private String inputLPPublicationDate() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast Udgivelsesdato på LP:  ");
        String publicationDate = keyboard.nextLine();
        return publicationDate;
    }
}

