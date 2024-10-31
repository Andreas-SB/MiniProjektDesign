package tui;

import java.util.Scanner;

/**
 * MainMenu-klassen repræsenterer hovedmenuen for programmet og styrer navigationen til 
 * de forskellige under-menuer, såsom venne-menuen, LP-menuen og udlåns-menuen.
 *
 * Forfatter: Gruppe 2 
 * Version: 0.1.0
 */
public class MainMenu {
    // Instansvariabler
    private LoanMenu loanMenu;   // Referencer til udlåns-menuen
    private FriendMenu friendMenu; // Referencer til venne-menuen
    private LPMenu lpMenu;        // Referencer til LP-menuen

    /**
     * Konstruktør for MainMenu-objektet.
     * Initialiserer instansvariablerne for de forskellige menuer.
     */
    public MainMenu() {
        loanMenu = new LoanMenu();
        friendMenu = new FriendMenu();
        lpMenu = new LPMenu();
    }
    
    /**
     * Starter hovedmenuen.
     */
    public void start() {
        mainMenu();
    }
    
    /**
     * Viser hovedmenuen og håndterer brugerens valg.
     * Kører indtil brugeren vælger at afslutte programmet.
     */
    private void mainMenu() {
        boolean running = true;
        while (running) {
            int choice = writeMainMenu();
            switch (choice) {
                case 1: // Venne-menu
                  System.out.println("Ven menu");
                  friendMenu.start(); // Starter venne-menuen
                  break;
                case 2: // LP-menu
                  System.out.println("LP menu");
                  lpMenu.start(); // Starter LP-menuen
                  break;
                case 3: // Udlåns-menu
                  loanMenu.start(); // Starter udlåns-menuen
                  break;
                case 9: // Generer testdata
                  System.out.println("Denne er ikke implementeret endnu");
                  createTestData(); // Metode til at generere testdata (ikke implementeret)
                  break;
                case 0: // Afslut programmet
                  System.out.println("Tak for denne gang.");
                  running = false; // Stopper programmet
                  break;
                default:
                  System.out.println("Der er sket en uforklarlig fejl, choice = "+choice);
                  break;
            }
        }
    }

    /**
     * Viser hovedmenuens valgmuligheder og læser brugerens valg.
     *
     * @return int - Brugerens valg som et heltal.
     */
    private int writeMainMenu() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("****** Hovedmenu ******");
        System.out.println(" (1) Ven menu");
        System.out.println(" (2) LP menu");
        System.out.println(" (3) Udlånsmenu");
        System.out.println(" (9) Generer testdata"); // Vil generere testdata, fjern i final version
        System.out.println(" (0) Afslut programmet");
        System.out.print("\n Vælg:");
        
        // Kontrollerer at input er et heltal
        while (!keyboard.hasNextInt()) {
            System.out.println("Input skal være et tal - prøv igen");
            keyboard.nextLine();
        }
        int choice = keyboard.nextInt();
        return choice; // Returnerer brugerens valg
    }
    
    /**
     * Metode til at generere testdata.
     * Denne metode er ikke implementeret i øjeblikket.
     */
    private void createTestData() {
        // Hent instans
        // Opret nogle venner og LP'er
    }
}
