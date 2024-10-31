package model;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * LPContainer håndterer opbevaring og styring af LP (plade) objekter og deres kopier.
 * Denne klasse implementerer Singleton-mønsteret for at sikre, at der kun eksisterer
 * én instans af LPContainer i systemet.
 * 
 * @author Gruppe 2 
 * @version 0.1.0
 */
public class LPContainer {
    // Instansvariabler
    private static LPContainer uniqueInstance; // Singleton instans
    private ArrayList<LP> listLPS; // Liste til at gemme LP objekter
    private ArrayList<LPCopy> listLPCopys; // Liste til at gemme LPCopy objekter

    /**
     * Konstruktør for objekter af klassen LPContainer.
     * Initialiserer listerne til at gemme LP og LPCopy objekter.
     */
    private LPContainer() {
        listLPS = new ArrayList<>();
        listLPCopys = new ArrayList<>();
    }

    /**
     * Tilføjer en LP til containeren.
     * 
     * @param l LP objektet der skal tilføjes.
     */
    public void addLP(LP l) {
        listLPS.add(l);
    }

    /**
     * Tilføjer en LPCopy til containeren.
     * 
     * @param lc LPCopy objektet der skal tilføjes.
     */
    public void addLPCopy(LPCopy lc) {
        listLPCopys.add(lc);
    }

    /**
     * Henter den unikke instans af LPContainer (Singleton).
     * 
     * @return Den unikke instans af LPContainer.
     */
    public static LPContainer getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new LPContainer();
        }
        return uniqueInstance;
    }

    /**
     * Finder en LP baseret på titlen.
     * 
     * @param title Titlen på LP'en der skal findes.
     * @return Det fundne LP objekt eller null hvis ikke fundet.
     */
    public LP findLPByTitle(String title) {
        LP lp = null;
        boolean found = false;
        Iterator<LP> iterator = listLPS.iterator();
        while (iterator.hasNext() && !found) {
            LP l = iterator.next();
            if (title.equals(l.getTitle())) {
                found = true;
                lp = l;
            }
        }
        return lp;
    }

    /**
     * Finder en LPCopy baseret på serienummeret.
     * 
     * @param serialNumber Serienummeret for LPCopy'en der skal findes.
     * @return Det fundne LPCopy objekt eller null hvis ikke fundet.
     */
    public LPCopy findLPCopyByBarcode(String serialNumber) {
        LPCopy lpcopy = null;
        boolean found = false;
        Iterator<LPCopy> iterator = listLPCopys.iterator();
        while (iterator.hasNext() && !found) {
            LPCopy lc = iterator.next();
            if (serialNumber.equals(lc.getSerialNumber())) {
                found = true;
                lpcopy = lc;
            }
        }
        return lpcopy;
    }

    /**
     * Finder LP'en som en LPCopy tilhører.
     * 
     * @param copy LPCopy objektet hvis tilhørende LP skal findes.
     * @return Det fundne LP objekt eller null hvis ikke fundet.
     */
    public LP findLPForCopy(LPCopy copy) {
        for (LP lp : listLPS) {
            ArrayList<LPCopy> copies = lp.getListCopy();
            if (copies.contains(copy)) {
                return lp;
            }
        }
        return null;
    }
}
