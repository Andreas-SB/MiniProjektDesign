package controller;
import model.LP;
import model.LPCopy;
import model.LPContainer;

/**
 * LPController håndterer operationer relateret til LP'er (Long Play).
 * Denne klasse giver funktioner til at finde og oprette LP'er samt LP-kopier.
 * 
 * @author Gruppe 2 
 * @version 0.1.0
 */
public class LPController {
    // Instansvariabler
    private LP foundLP;
    private LPContainer uniqueContainer;

    /**
     * Konstruktør for LPController-objekter.
     * Initialiserer instansvariablen uniqueContainer som en unik instans af LPContainer.
     */
    public LPController() {
        uniqueContainer = LPContainer.getUniqueInstance();
    }

    /**
     * Opretter en ny LP med de angivne oplysninger og tilføjer den til LPContainer.
     * 
     * @param barcode Stregekoden til LP'en.
     * @param title Titlen på LP'en.
     * @param artist Kunstneren af LP'en.
     * @param publicationDate Udgivelsesdatoen for LP'en.
     * @return Det oprettede LP-objekt.
     */
    public LP createLP(String barcode, String title, String artist, String publicationDate) {
        LP l = new LP(barcode, title, artist, publicationDate);
        uniqueContainer.addLP(l);
        return l;
    }

    /**
     * Opretter en ny LP-kopi med de angivne oplysninger og tilføjer den til LPContainer.
     * 
     * @param serialNumber Serienummeret for LP-kopien.
     * @param purchaseDate Indkøbsdatoen for LP-kopien.
     * @param purchasePrice Indkøbsprisen for LP-kopien.
     * @param condition Tilstanden af LP-kopien.
     * @return Det oprettede LPCopy-objekt.
     */
    public LPCopy createLPCopy(String serialNumber, String purchaseDate, String purchasePrice, String condition) {
        LPCopy lc = new LPCopy(serialNumber, purchaseDate, purchasePrice, condition);
        uniqueContainer.addLPCopy(lc);
        return lc;
    }

    /**
     * Søger efter en LP baseret på dens titel.
     * 
     * @param title Titlen på LP'en der skal findes.
     * @return Det fundne LP-objekt eller null, hvis ingen LP med den titel blev fundet.
     */
    public LP findLP(String title) {
        LPContainer instance = LPContainer.getUniqueInstance();
        foundLP = instance.findLPByTitle(title);
        return foundLP;
    }

    /**
     * Søger efter en LP baseret på en LP-kopi.
     * 
     * @param lpCopy Den LP-kopi der ønskes at finde den tilhørende LP for.
     * @return Det fundne LP-objekt eller null, hvis LP'en for denne kopi ikke findes.
     */
    public LP findLP(LPCopy lpCopy) {
        foundLP = uniqueContainer.findLPForCopy(lpCopy);
        return foundLP;
    }

    /**
     * Søger efter en LP-kopi baseret på serienummeret.
     * 
     * @param serialNumber Serienummeret for LP-kopien der skal findes.
     * @return Det fundne LPCopy-objekt eller null, hvis ingen kopi blev fundet.
     */
    public LPCopy findLPCopy(String serialNumber) {
        LPContainer instance = LPContainer.getUniqueInstance();
        return instance.findLPCopyByBarcode(serialNumber);
    }

    /**
     * Søger efter en LP-kopi og dens tilhørende LP-baseret på serienummeret.
     * 
     * @param serialNumber Serienummeret for LP-kopien.
     * @return LPCopy-objektet hvis fundet, eller null hvis ingen kopi findes.
     */
    public LPCopy findLPCopyAndTitle(String serialNumber) {
        LPCopy copy = uniqueContainer.findLPCopyByBarcode(serialNumber);
        return copy;
    }
}
