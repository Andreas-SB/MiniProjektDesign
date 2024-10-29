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
    private LocalDate borrowDate;
    private LocalDate period;
    private String state;
    private LocalDate returnDate;
    
    
    /**
     * Constructor for objects of class Loan
     */
    public Loan(String loanNumber, LocalDate borrowDate,LocalDate period,String state,LocalDate returnDate)
    {
        // initialise instance variables
        this.loanNumber = loanNumber;
        this.borrowDate = borrowDate;
        this.period = period;
        this.state = state;
        this.returnDate = returnDate;
        
    }

}
