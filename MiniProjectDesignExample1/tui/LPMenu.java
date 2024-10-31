package tui;
import java.util.Scanner;
import model.LP;
import model.LPCopy;
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
                    createLPCopy();
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
                case 4:
                    System.out.println(" (4) Søg LP kopi");
                    findLPCopy();
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
        System.out.println(" (4) Søg LP kopi");
        System.out.println(" (0) Tilbage");
        System.out.print("\n Vælg:");
        int choice = getIntegerFromUser(keyboard);
        return choice;
    }
    
    private LP findLP() {
        String title = inputLPTitle();
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
    
    private void findLPCopy() {
        String serialNumber = inputLPCopySerialNumber();
        LPController controller = new LPController();      
        String[] result = controller.findLPCopyAndTitle(serialNumber);
        if (result != null) {
            System.out.println("LP kopi fundet med serienummer: " + result[0]);
            System.out.println("Tilhører LP'en: " + result[1]);
        } else {
            System.out.println("LP kopi ikke fundet");
        }
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
    
    
    private LP createLPCopy(){
        String serialNumber = inputLPCopySerialNumber();
        String purchaseDate = inputLPCopyPurchaseDate();
        String purchasePrice = inputLPCopyPurchasePrice();
        String condition = inputLPCopyCondition();
        String title = inputLPTitle();

        LPController controller = new LPController();
        LP lp = controller.findLP(title);
        if (lp == null) {
            System.out.println("LP findes ikke");
            return null;
        } else {
            LPCopy lpCopy = controller.createLPCopy(serialNumber, purchaseDate, purchasePrice, condition);
            lp.addLPCopy(lpCopy);
            System.out.println("LP kopi lavet for: " + lp.getTitle());
            return lp;
        }
    }
    private String inputLPCopySerialNumber() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast serienummer på LP:  ");
        String serialNumber = keyboard.nextLine();
        return serialNumber;
    }
    private String inputLPCopyPurchaseDate() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast indkøbsdato på LP:  ");
        String purchaseDate = keyboard.nextLine();
        return purchaseDate;
    }
    private String inputLPCopyPurchasePrice() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast indkøbspris på LP:  ");
        String purchasePrice = keyboard.nextLine();
        return purchasePrice;
    }
    private String inputLPCopyCondition() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast tilstand på LP:  ");
        String condition = keyboard.nextLine();
        return condition;
    }
}

