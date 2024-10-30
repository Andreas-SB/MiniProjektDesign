package controller;
import model.Loan;
import model.LoanContainer;
import java.time.LocalDate;


/**
 * Write a description of class LoanController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LoanController
{
    // instance variables - replace the example below with your own
    private Loan foundLoan;
    /**
     * Constructor for objects of class LoanController
     */
    public LoanController()
    {
        // initialise instance variables
    }

    public Loan findLoan(String loanNumber){
        LoanContainer instance = LoanContainer.getUniqueInstance();
        foundLoan = instance.findLoanByLoanNumber(loanNumber);
        return foundLoan;
    }
    public Loan createLoan(String loanNumber, String borrowDate, String period, String state, String returnDate){
        Loan lo = new Loan(loanNumber, borrowDate, period, state, returnDate);
        LoanContainer instance = LoanContainer.getUniqueInstance();
        instance.addLoan(lo);
        return lo;
    }
}
