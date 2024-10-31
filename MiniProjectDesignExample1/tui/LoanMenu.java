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
     * Konstruktør for objekter af klassen LoanMenu
     */
    public LoanMenu() {
        // Initialiserer instansvariablerne
        friendController = new FriendController();
        lpController = new LPController();
        loanController = new LoanController();
    }

    /**
     * Starter lånermenuen.
     */
    public void start() {
        loanMenu();
    }

    /**
     * Viser lånermenuen og håndterer brugerens valg.
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
     * Skriver lånermenuen og returnerer brugerens valg.
     * 
     * @return det valgte menupunkt.
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
     * Henter et heltal fra brugeren.
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
     * Finder et lån baseret på lånenummer.
     * 
     * @return det fundne Loan-objekt eller null hvis ikke fundet.
     */
    private Loan findLoan() {
        String loanNumber = inputLoanNumber();
        LoanController controller = new LoanController();      
        Loan loan = controller.findLoan(loanNumber);
        return loan;
    }

    /**
     * Opretter et lån ved at hente oplysninger fra brugeren.
     */
    private void createLoan() {
        System.out.println("");
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
     * @return det indtastede lånenummer.
     */
    private String inputLoanNumber() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast Lånenummer på Lån:  ");
        String loanNumber = keyboard.nextLine();
        return loanNumber;
    }

    /**
     * Henter lånedato fra brugeren.
     * 
     * @return den indtastede lånedato.
     */
    private String inputBorrowDate() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast lånedato på Lån:  ");
        String borrowDate = keyboard.nextLine();
        return borrowDate;
    }

    /**
     * Henter låneperioden fra brugeren.
     * 
     * @return den indtastede låneperiode.
     */
    private String inputPeriod() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast låneperiode på Lån:  ");
        String period = keyboard.nextLine();
        return period;
    }

    /**
     * Henter status på lånet fra brugeren.
     * 
     * @return den indtastede status.
     */
    private String inputState() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast stadie på Lån:  ");
        String state = keyboard.nextLine();
        return state;
    }

    /**
     * Henter returdatoen fra brugeren.
     * 
     * @return den indtastede returdato.
     */
    private String inputReturnDate() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast retunerdato på Lån:  ");
        String returnDate = keyboard.nextLine();
        return returnDate;
    }

    /**
     * Henter serienummeret på LP-kopien fra brugeren.
     * 
     * @return det indtastede serienummer.
     */
    private String inputLPCopySerialNumber() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast serienummer på LP kopi:  ");
        return keyboard.nextLine();
    }

    /**
     * Henter telefonnummeret på vennen fra brugeren.
     * 
     * @return det indtastede telefonnummer.
     */
    private String inputFriendPhone() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast telefonnummer på ven:  ");
        return keyboard.nextLine();
    }
    
    /**
     * Beskriver lånet ved at udskrive dets oplysninger.
     */
    public void describeLoan(Loan loan) {
        System.out.println("Lånenummer for lån er: " + loan.getLoanNumber());
        System.out.println("Lånedato for lån er: " + loan.getBorrowDate());
        System.out.println("Låneperiode for lån er: " + loan.getPeriod());
        System.out.println("Stadie på lån er: " + loan.getState());
        System.out.println("Retunerdato for lån er: " + loan.getReturnDate());
    }
}
