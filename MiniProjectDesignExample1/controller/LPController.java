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

    /**
     * Konstruktør for objekter af klassen LPController.
     * Initialiserer instansvariablerne.
     */
    public LPController() {
        // Initialiserer instansvariabler
    }

    /**
     * Opretter en ny LP med de angivne oplysninger.
     * 
     * @param barcode Stregekoden til LP'en.
     * @param title Titlen på LP'en.
     * @param artist Kunstneren af LP'en.
     * @param publicationDate Udgivelsesdatoen for LP'en.
     * @return Det oprettede LP-objekt.
     */
    public LP createLP(String barcode, String title, String artist, String publicationDate) {
        LP l = new LP(barcode, title, artist, publicationDate);
        LPContainer instance = LPContainer.getUniqueInstance();
        instance.addLP(l);
        return l;
    }

    /**
     * Opretter en ny LP-kopi med de angivne oplysninger.
     * 
     * @param serialNumber Serienummeret for LP-kopien.
     * @param purchaseDate Indkøbsdatoen for LP-kopien.
     * @param purchasePrice Indkøbsprisen for LP-kopien.
     * @param condition Tilstanden af LP-kopien.
     * @return Det oprettede LPCopy-objekt.
     */
    public LPCopy createLPCopy(String serialNumber, String purchaseDate, String purchasePrice, String condition) {
        LPCopy lc = new LPCopy(serialNumber, purchaseDate, purchasePrice, condition);
        LPContainer instance = LPContainer.getUniqueInstance();
        instance.addLPCopy(lc);
        return lc;
    }

    /**
     * Finder en LP baseret på titlen.
     * 
     * @param title Titlen på LP'en der skal findes.
     * @return Det fundne LP-objekt eller null hvis ikke fundet.
     */
    public LP findLP(String title) {
        LPContainer instance = LPContainer.getUniqueInstance();
        foundLP = instance.findLPByTitle(title);
        return foundLP;
    }

    /**
     * Finder en LP-kopi baseret på serienummeret.
     * 
     * @param serialNumber Serienummeret for LP-kopien der skal findes.
     * @return Det fundne LPCopy-objekt eller null hvis ikke fundet.
     */
    public LPCopy findLPCopy(String serialNumber) {
        LPContainer instance = LPContainer.getUniqueInstance();
        return instance.findLPCopyByBarcode(serialNumber);
    }

    /**
     * Finder en LP-kopi og dens tilhørende LP-baseret på serienummeret.
     * 
     * @param serialNumber Serienummeret for LP-kopien.
     * @return Et array der indeholder LP-kopiens serienummer og LP'ens titel,
     *         eller null hvis ikke fundet.
     */
    public String[] findLPCopyAndTitle(String serialNumber) {
        LPContainer instance = LPContainer.getUniqueInstance();
        LPCopy copy = instance.findLPCopyByBarcode(serialNumber);
        if (copy != null) {
            LP lp = instance.findLPForCopy(copy);
            if (lp != null) {
                return new String[]{copy.getSerialNumber(), lp.getTitle()};
            }
        }
        return null;
    }
}
