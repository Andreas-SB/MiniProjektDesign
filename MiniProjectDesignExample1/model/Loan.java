package model;
import java.time.LocalDate;


/**
 * Write a description of class Loan here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Loan
{
    // instance variables - replace the example below with your own
    private String loanNumber;
    private String borrowDate;
    private String period;
    private String state;
    private String returnDate;
    
    
    /**
     * Constructor for objects of class Loan
     */
    public Loan(String loanNumber, String borrowDate,String period,String state,String returnDate)
    {
        // initialise instance variables
        this.loanNumber = loanNumber;
        this.borrowDate = borrowDate;
        this.period = period;
        this.state = state;
        this.returnDate = returnDate;
        
    }
    public String getLoanNumber(){
        return loanNumber;
    }
    public String getBorrowDate(){
        return borrowDate;
    }
    public String getPeriod(){
        return period;
    }
    public String getState(){
        return state;
    }
    public String getReturnDate(){
        return returnDate;
    }
    
    public void describeLoan(){
        System.out.println("Lånenummer for lån er: " + loanNumber);
        System.out.println("Lånedato for lån er: " + borrowDate);
        System.out.println("Låneperiode for lån er: " + period);
        System.out.println("Stadie på lån er: " + state);
        System.out.println("Retunerdato for lån er: " + returnDate);
    }
}
