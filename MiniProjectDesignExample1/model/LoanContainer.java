package model;
import java.util.ArrayList;


/**
 * Write a description of class LoanContainer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LoanContainer
{
    // instance variables - replace the example below with your own
    private ArrayList<Loan>listLoans;
    /**
     * Constructor for objects of class LoanContainer
     */
    public LoanContainer()
    {
        // initialise instance variables
        listLoans = new ArrayList<>();
    }
    public void addLoan(Loan lo){
        listLoans.add(lo);
    }

}
