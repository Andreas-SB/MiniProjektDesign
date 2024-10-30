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
}
