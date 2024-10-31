package model;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * LoanContainer er en singleton-klasse, der administrerer en samling af lån.
 * Den giver funktionalitet til at tilføje lån og søge efter lån baseret på lånenummer.
 * 
 * @author Gruppe 2 
 * @version 0.1.0
 */
public class LoanContainer {
    // Instansvariabler
    private ArrayList<Loan> listLoans;     // Liste over lån
    private static LoanContainer uniqueInstance; // Singleton instans

    /**
     * Konstruktør for objekter af klassen LoanContainer.
     * Initialiserer listen over lån.
     */
    public LoanContainer() {
        listLoans = new ArrayList<>();
    }

    /**
     * Henter den unikke instans af LoanContainer (singleton).
     * 
     * @return Den unikke instans af LoanContainer.
     */
    public static LoanContainer getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new LoanContainer();
        }
        return uniqueInstance;
    }

    /**
     * Tilføjer et lån til listen over lån.
     * 
     * @param lo Lånet, der skal tilføjes.
     */
    public void addLoan(Loan lo) {
        listLoans.add(lo);
    }

    /**
     * Finder et lån baseret på lånenummer.
     * 
     * @param loanNumber Lånenummeret for det lån, der skal findes.
     * @return Det fundne lån, eller null hvis det ikke findes.
     */
    public Loan findLoanByLoanNumber(String loanNumber) {
        Loan loan = null;
        boolean found = false;
        Iterator<Loan> iterator = listLoans.iterator();
        while (iterator.hasNext() && !found) {
            Loan lo = iterator.next();
            if (loanNumber.equals(lo.getLoanNumber())) {
                found = true;
                loan = lo;
            }
        }
        return loan;
    }
}
