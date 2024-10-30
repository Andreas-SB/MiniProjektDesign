package model;
import java.util.ArrayList;
import java.util.Iterator;


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
    private static LoanContainer  uniqueInstance;
    /**
     * Constructor for objects of class LoanContainer
     */
    public LoanContainer()
    {
        // initialise instance variables
        listLoans = new ArrayList<>();
    }
    public static LoanContainer getUniqueInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new LoanContainer();
        }
        return uniqueInstance;
    }
    public void addLoan(Loan lo){
        listLoans.add(lo);
    }
    public Loan findLoanByLoanNumber(String loanNumber){
        Loan loan = null;
        boolean found = false;
        Iterator<Loan> iterator = listLoans.iterator();
        while(iterator.hasNext()&& !found){
            Loan lo = iterator.next();
            if(loanNumber.equals(lo.getLoanNumber())){
                found = true;
                loan = lo;
            }
        
        }
        return loan;
    }
}
