package model;

/**
 * Loan repræsenterer et lån med tilknyttede oplysninger som lånenummer, 
 * lånedato, låneperiode, lånestatus og returdate.
 * 
 * @author Gruppe 2 
 * @version 0.1.0
 */
public class Loan {
    // Instansvariabler
    private String loanNumber;    // Lånenummer
    private String borrowDate;     // Dato for lånets oprettelse
    private String period;         // Låneperiode
    private String state;          // Lånets nuværende status
    private String returnDate;     // Dato for forventet returnering

    /**
     * Konstruktør for objekter af klassen Loan.
     * Initialiserer instansvariablerne med de angivne værdier.
     * 
     * @param loanNumber Lånenummeret for dette lån.
     * @param borrowDate Datoen for hvornår lånet blev taget.
     * @param period Låneperioden (f.eks. antal dage).
     * @param state Lånets nuværende status (f.eks. aktiv, afsluttet).
     * @param returnDate Datoen for hvornår lånet skal returneres.
     */
    public Loan(String loanNumber, String borrowDate, String period, String state, String returnDate) {
        this.loanNumber = loanNumber;
        this.borrowDate = borrowDate;
        this.period = period;
        this.state = state;
        this.returnDate = returnDate;
    }

    // Getter metoder
    public String getLoanNumber() {
        return loanNumber;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public String getPeriod() {
        return period;
    }

    public String getState() {
        return state;
    }

    public String getReturnDate() {
        return returnDate;
    }

    /**
     * Beskriver lånet ved at udskrive dets oplysninger.
     */
    public void describeLoan() {
        System.out.println("Lånenummer for lån er: " + loanNumber);
        System.out.println("Lånedato for lån er: " + borrowDate);
        System.out.println("Låneperiode for lån er: " + period);
        System.out.println("Stadie på lån er: " + state);
        System.out.println("Retunerdato for lån er: " + returnDate);
    }
}
