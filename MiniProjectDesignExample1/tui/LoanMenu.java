package tui;
import java.util.Scanner;
import model.Loan;
import model.Friend;
import model.LPCopy;
import controller.LoanController;
import controller.FriendController;
import controller.LPController;

/**
 * LoanMenu håndterer brugerinteraktionen for lån af LP-kopier.
 * Brugeren kan oprette et lån, søge efter et eksisterende lån og få vist lånedetaljer.
 *
 * @author Gruppe 2 
 * @version 0.1.0
 */
public class LoanMenu {
    // Instansvariabler
    private FriendController friendController;
    private LPController lpController;
    private LoanController loanController;

    /**
     * Konstruktør for LoanMenu-objektet.
     * Initialiserer controllerne til håndtering af venner, LP'er og lån.
     */
    public LoanMenu() {
        friendController = new FriendController();
        lpController = new LPController();
        loanController = new LoanController();
    }

    /**
     * Starter lånermenuen.
     * Denne metode viser menuen og lader brugeren vælge mellem forskellige lånehandlinger.
     */
    public void start() {
        loanMenu();
    }

    /**
     * Viser lånermenuen og håndterer brugerens valg.
     * Brugeren kan oprette lån, søge lån eller afslutte menuen.
     */
    private void loanMenu() {
        boolean running = true;
        while (running) {
            int choice = writeLoanMenu();
            switch (choice) {
                case 1:
                    System.out.println(" Opret et lån");
                    createLoan();
                    break;
                case 2:
                    System.out.println(" Søg efter lån");
                    Loan loan = findLoan();
                    if (loan == null) {
                        System.out.println("Lån er ikke fundet");
                    } else {
                        describeLoan(loan);
                    }
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("En uforklarlig fejl er sket med choice = " + choice);
                    break;
            }
        }
    }

    /**
     * Skriver lånermenuens valgmuligheder og returnerer brugerens valg.
     * 
     * @return det valgte menupunkt som et heltal.
     */
    private int writeLoanMenu() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("****** Udlånsmenu ******");
        System.out.println(" (1) Opret lån");
        System.out.println(" (2) Opsøg lån");
        System.out.println(" (0) Tilbage");
        System.out.print("\n Vælg:");
        int choice = getIntegerFromUser(keyboard);
        return choice;
    }

    /**
     * Henter et heltal fra brugeren og håndterer ikke-numerisk input.
     * 
     * @param keyboard Scanner til at læse brugerinput.
     * @return det indtastede heltal.
     */
    private int getIntegerFromUser(Scanner keyboard) {
        while (!keyboard.hasNextInt()) {
            System.out.println("Input skal være et tal - prøv igen");
            keyboard.nextLine();
        }
        return keyboard.nextInt();
    }

    /**
     * Finder et lån baseret på lånenummeret indtastet af brugeren.
     * 
     * @return det fundne Loan-objekt, eller null hvis ikke fundet.
     */
    private Loan findLoan() {
        String loanNumber = inputLoanNumber();
        Loan loan = loanController.findLoan(loanNumber);
        return loan;
    }

    /**
     * Opretter et lån ved at hente oplysninger om LP-kopi og ven fra brugeren.
     */
    private void createLoan() {
        System.out.println("Find LP kopi:");
        String serialNumber = inputLPCopySerialNumber();
        LPCopy lpCopy = lpController.findLPCopy(serialNumber);
        if (lpCopy == null) {
            System.out.println("LP kopi ikke fundet");
            return;
        }

        System.out.println("Find ven:");
        String phone = inputFriendPhone();
        Friend friend = friendController.findFriend(phone);
        if (friend == null) {
            System.out.println("Ven ikke fundet");
            return;
        }

        String loanNumber = inputLoanNumber();
        String borrowDate = inputBorrowDate();
        String period = inputPeriod();
        String state = inputState();
        String returnDate = inputReturnDate();

        Loan loan = loanController.createLoan(loanNumber, borrowDate, period, state, returnDate);
        System.out.println("Lån oprettet til " + friend.getName() + " for LP kopi: " + serialNumber);
    }

    /**
     * Henter lånenummer fra brugeren.
     * 
     * @return det indtastede lånenummer som en streng.
     */
    private String inputLoanNumber() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast lånenummer på lån: ");
        return keyboard.nextLine();
    }

    /**
     * Henter lånedato fra brugeren.
     * 
     * @return den indtastede lånedato som en streng.
     */
    private String inputBorrowDate() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast lånedato på lån: ");
        return keyboard.nextLine();
    }

    /**
     * Henter låneperioden fra brugeren.
     * 
     * @return den indtastede låneperiode som en streng.
     */
    private String inputPeriod() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast låneperiode på lån: ");
        return keyboard.nextLine();
    }

    /**
     * Henter lånets status fra brugeren.
     * 
     * @return den indtastede status som en streng.
     */
    private String inputState() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast status på lån: ");
        return keyboard.nextLine();
    }

    /**
     * Henter returdatoen for lånet fra brugeren.
     * 
     * @return den indtastede returdato som en streng.
     */
    private String inputReturnDate() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast returdato på lån: ");
        return keyboard.nextLine();
    }

    /**
     * Henter serienummeret for LP-kopien fra brugeren.
     * 
     * @return det indtastede serienummer som en streng.
     */
    private String inputLPCopySerialNumber() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast serienummer på LP kopi: ");
        return keyboard.nextLine();
    }

    /**
     * Henter telefonnummeret på vennen fra brugeren.
     * 
     * @return det indtastede telefonnummer som en streng.
     */
    private String inputFriendPhone() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast telefonnummer på ven: ");
        return keyboard.nextLine();
    }
    
    /**
     * Beskriver og viser oplysninger om et lån.
     * 
     * @param loan Lån-objektet, der skal beskrives.
     */
    public void describeLoan(Loan loan) {
        System.out.println("Lånenummer: " + loan.getLoanNumber());
        System.out.println("Lånedato: " + loan.getBorrowDate());
        System.out.println("Låneperiode: " + loan.getPeriod());
        System.out.println("Status: " + loan.getState());
        System.out.println("Returdato: " + loan.getReturnDate());
    }
}
