package tui;
import java.util.Scanner;
import model.Loan;
import controller.LoanController;


/**
 * Write a description of class LoanMenu here.
 *
 * @author Mogens Holm Iversen
 * @version 0.1.0 Initial draft version 
 */
public class LoanMenu {
    // instance variables
    

    /**
     * Constructor for objects of class LoanMenu
     */
    public LoanMenu() {
        // initialise instance variables
        
       
    }

    public void start() {
        loanMenu();
    }

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
                     if (loan == null){
                        System.out.println("Lån er ikke fundet");
                    }
                    else{
                        System.out.println("Lån er fundet " + loan.getLoanNumber());
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
    
    private int getIntegerFromUser(Scanner keyboard) {
        while (!keyboard.hasNextInt()) {
            System.out.println("Input skal være et tal - prøv igen");
            keyboard.nextLine();
        }
        return keyboard.nextInt();
    }
    
     private Loan findLoan() {
        String loanNumber = inputLoanNumber();
        LoanController controller = new LoanController();      
        Loan loan = controller.findLoan(loanNumber);
        return loan;
    }
    
    
    private void createLoan(){
        String loanNumber = inputLoanNumber();
        String borrowDate = inputBorrowDate();
        String period = inputPeriod();
        String state = inputState();
        String returnDate = inputReturnDate();
        LoanController controller = new LoanController();
        Loan loan = controller.createLoan(loanNumber, borrowDate, period,state, returnDate);
        System.out.println("Lån er lavet: " + loan.getLoanNumber());
    }
    private String inputLoanNumber() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast Lånenummer på Lån:  ");
        String loanNumber = keyboard.nextLine();
        return loanNumber;
    }
    private String inputBorrowDate() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast lånedato på Lån:  ");
        String borrowDate = keyboard.nextLine();
        return borrowDate;
    }
    private String inputPeriod() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast låneperiode på Lån:  ");
        String period = keyboard.nextLine();
        return period;
    }
    private String inputState() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast stadie på Lån:  ");
        String state = keyboard.nextLine();
        return state;
    }
    private String inputReturnDate() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast retunerdato på Lån:  ");
        String returnDate = keyboard.nextLine();
        return returnDate;
    }
}

