package controller;
import model.Loan;
import model.LoanContainer;

/**
 * LoanController håndterer operationer relateret til lån i systemet.
 * Denne klasse giver funktioner til at finde og oprette lån.
 * 
 * @author Gruppe 2 
 * @version 0.1.0
 */
public class LoanController {
    // Instansvariabler
    private Loan foundLoan;

    /**
     * Konstruktør for objekter af klassen LoanController.
     * Initialiserer instansvariablerne.
     */
    public LoanController() {
        // Initialiserer instansvariabler
    }

    /**
     * Finder et lån baseret på lånenummeret.
     * 
     * @param loanNumber Lånenummeret for det lån der skal findes.
     * @return Det fundne Loan-objekt eller null hvis ikke fundet.
     */
    public Loan findLoan(String loanNumber) {
        LoanContainer instance = LoanContainer.getUniqueInstance();
        foundLoan = instance.findLoanByLoanNumber(loanNumber);
        return foundLoan;
    }

    /**
     * Opretter et nyt lån med de angivne oplysninger.
     * 
     * @param loanNumber Lånenummeret for det nye lån.
     * @param borrowDate Lånedatoen for lånet.
     * @param period Låneperioden for lånet.
     * @param state Status for lånet.
     * @param returnDate Retur datoen for lånet.
     * @return Det oprettede Loan-objekt.
     */
    public Loan createLoan(String loanNumber, String borrowDate, String period, String state, String returnDate) {
        Loan lo = new Loan(loanNumber, borrowDate, period, state, returnDate);
        LoanContainer instance = LoanContainer.getUniqueInstance();
        instance.addLoan(lo);
        return lo;
    }
}
