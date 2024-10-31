package tui;
import java.util.Scanner;
import model.LP;
import model.LPCopy;
import controller.LPController;

/**
 * LPMenu-klassen repræsenterer menuen til håndtering af LP'er og deres kopier. 
 * Den giver brugeren mulighed for at oprette LP'er, oprette LP-kopier og søge efter 
 * eksisterende LP'er og LP-kopier.
 *
 * Forfatter: Gruppe 2 
 * Version: 0.1.0
 */
public class LPMenu
{
    // instance variables - replace the example below with your own

    /**
     * Konstruktør for LPMenu-objektet.
     * Initialiserer instansvariablerne, hvis det er nødvendigt.
     */
    public LPMenu()
    {
        // initialise instance variables

    }

    /**
     * Starter LP-menuen.
     */
    public void start() {
        LPMenu();
    }

    /**
     * Viser LP-menuen og håndterer brugerens valg.
     * Kører indtil brugeren vælger at gå tilbage.
     */
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
                        describeLP(lp);
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

    /**
     * Viser LP-menuens valgmuligheder og læser brugerens valg.
     *
     * @return int - Brugerens valg som et heltal.
     */
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

    /**
     * Finder en LP baseret på titel.
     *
     * @return LP - LP'en, hvis fundet; ellers null.
     */
    private LP findLP() {
        String title = inputLPTitle();
        LPController controller = new LPController();      
        LP lp = controller.findLP(title);
        return lp;
    }

    /**
     * Finder en LP-kopi baseret på serienummer.
     */
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

    /**
     * Metode til at få et heltal fra brugeren.
     *
     * @param keyboard Scanner-objektet til indlæsning af brugerinput.
     * @return int - Brugerens input som et heltal.
     */
    private int getIntegerFromUser(Scanner keyboard) {
        while (!keyboard.hasNextInt()) {
            System.out.println("Input skal være et tal - prøv igen");
            keyboard.nextLine();
        }
        return keyboard.nextInt();
    }

    /**
     * Opretter en ny LP med brugerens input.
     */
    private void createLP(){
        String barcode = inputLPBarcode();
        String title = inputLPTitle();
        String artist = inputLPArtist();
        String publicationDate = inputLPPublicationDate();
        LPController controller = new LPController();
        LP lp = controller.createLP(barcode, title, artist, publicationDate);
        System.out.println("LP lavet: " + lp.getTitle());
    }

    /**
     * Indlæser stregekoden på en LP fra brugeren.
     *
     * @return String - Stregekoden på LP'en.
     */
    private String inputLPBarcode() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast stregekode på LP:  ");
        String barcode = keyboard.nextLine();
        return barcode;
    }

    /**
     * Indlæser titlen på en LP fra brugeren.
     *
     * @return String - Titlen på LP'en.
     */
    private String inputLPTitle() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast Title på LP:  ");
        String title = keyboard.nextLine();
        return title;
    }

    /**
     * Indlæser kunstnerens navn fra brugeren.
     *
     * @return String - Kunstnerens navn.
     */
    private String inputLPArtist() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast Kunstner på LP:  ");
        String artist = keyboard.nextLine();
        return artist;
    }

    /**
     * Indlæser udgivelsesdatoen på en LP fra brugeren.
     *
     * @return String - Udgivelsesdatoen.
     */
    private String inputLPPublicationDate() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast Udgivelsesdato på LP:  ");
        String publicationDate = keyboard.nextLine();
        return publicationDate;
    }

    /**
     * Opretter en kopi af en LP med brugerens input.
     *
     * @return LP - Den LP, som kopien tilhører.
     */
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

    /**
     * Indlæser serienummeret på en LP-kopi fra brugeren.
     *
     * @return String - Serienummeret på kopien.
     */
    private String inputLPCopySerialNumber() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast serienummer på LP:  ");
        String serialNumber = keyboard.nextLine();
        return serialNumber;
    }

    /**
     * Indlæser indkøbsdatoen på en LP-kopi fra brugeren.
     *
     * @return String - Indkøbsdatoen.
     */
    private String inputLPCopyPurchaseDate() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast indkøbsdato på LP:  ");
        String purchaseDate = keyboard.nextLine();
        return purchaseDate;
    }

    /**
     * Indlæser indkøbsprisen på en LP-kopi fra brugeren.
     *
     * @return String - Indkøbsprisen.
     */
    private String inputLPCopyPurchasePrice() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast indkøbspris på LP:  ");
        String purchasePrice = keyboard.nextLine();
        return purchasePrice;
    }

    /**
     * Indlæser tilstanden på en LP-kopi fra brugeren.
     *
     * @return String - Tilstanden.
     */
    private String inputLPCopyCondition() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast tilstand på LP:  ");
        String condition = keyboard.nextLine();
        return condition;
    }

    /**
     * Beskriver oplysningerne om en LP.
     *
     * @param lp LP-objektet, der skal beskrives.
     */
    public void describeLP(LP lp){
        System.out.println("LP er fundet");
        System.out.println("Stregekoden til lp'en er: " + lp.getBarcode());
        System.out.println("Titlen på lp'en er: " + lp.getTitle());
        System.out.println("kunstner på lp'en er: " + lp.getArtist());
        System.out.println("Udgivelsesdato på lp'en er: " + lp.getPublicationDate());
    }

    /**
     * Beskriver oplysningerne om en LP-kopi.
     *
     * @param lpcopy LPCopy-objektet, der skal beskrives.
     */
    public void describeLPCopy(LPCopy lpcopy){
        System.out.println("Serienummer på lp kopi'en er: " + lpcopy.getSerialNumber());
        System.out.println("Indkøbsdato på lp kopi'en er: " + lpcopy.getPurchaseDate());
        System.out.println("Indkøbspris på lp kopi'en er: " + lpcopy.getPurchasePrice());
        System.out.println("Tilstand på lp kopi'en er: " + lpcopy.getCondition());
    }
}

