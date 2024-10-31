package model;

/**
 * LPCopy repræsenterer en kopi af en vinylplade med oplysninger som
 * serienummer, indkøbsdato, indkøbspris og tilstand.
 * 
 * @author Gruppe 2 
 * @version 0.1.0
 */
public class LPCopy {
    // Instansvariabler
    private String serialNumber; // Serienummer for LP kopien
    private String purchaseDate; // Indkøbsdato for LP kopien
    private String purchasePrice; // Indkøbspris for LP kopien
    private String condition; // Tilstand på LP kopien

    /**
     * Konstruktør for objekter af klassen LPCopy.
     * 
     * @param serialNumber Serienummer for LP kopien
     * @param purchaseDate Indkøbsdato for LP kopien
     * @param purchasePrice Indkøbspris for LP kopien
     * @param condition Tilstand på LP kopien
     */
    public LPCopy(String serialNumber, String purchaseDate, String purchasePrice, String condition) {
        // Initialiserer instansvariablerne
        this.serialNumber = serialNumber;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
        this.condition = condition;
    }

    /**
     * Henter serienummeret for LP kopien.
     * 
     * @return Serienummer som en String.
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * Henter indkøbsdatoen for LP kopien.
     * 
     * @return Indkøbsdato som en String.
     */
    public String getPurchaseDate() {
        return purchaseDate;
    }

    /**
     * Henter indkøbsprisen for LP kopien.
     * 
     * @return Indkøbspris som en String.
     */
    public String getPurchasePrice() {
        return purchasePrice;
    }

    /**
     * Henter tilstanden for LP kopien.
     * 
     * @return Tilstand som en String.
     */
    public String getCondition() {
        return condition;
    }
}
