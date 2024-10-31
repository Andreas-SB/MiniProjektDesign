package model;
import java.util.ArrayList;

/**
 * LP repræsenterer en vinylplade med tilknyttede kopier.
 * Klassen indeholder oplysninger som stregkode, titel, kunstner og
 * udgivelsesdato for LP'en samt en liste over dens kopier.
 * 
 * @author Gruppe 2 
 * @version 0.1.0
 */
public class LP {
    // Instansvariabler
    private String barcode; // Stregkode for LP'en
    private String title; // Titel på LP'en
    private String artist; // Kunstner af LP'en
    private String publicationDate; // Udgivelsesdato for LP'en
    private ArrayList<LPCopy> listCopy; // Liste over kopier af LP'en

    /**
     * Konstruktør for objekter af klassen LP.
     * 
     * @param barcode Stregkode for LP'en
     * @param title Titel på LP'en
     * @param artist Kunstner af LP'en
     * @param publicationDate Udgivelsesdato for LP'en
     */
    public LP(String barcode, String title, String artist, String publicationDate) {
        // Initialiserer instansvariablerne
        this.barcode = barcode;
        this.title = title;
        this.artist = artist;
        this.publicationDate = publicationDate;
        this.listCopy = new ArrayList<>(); // Initialiserer listen over kopier
    }

    /**
     * Henter stregkoden for LP'en.
     * 
     * @return Stregkode som en String.
     */
    public String getBarcode() {
        return barcode;
    }

    /**
     * Henter titlen på LP'en.
     * 
     * @return Titel som en String.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Henter kunstneren af LP'en.
     * 
     * @return Kunstner som en String.
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Henter udgivelsesdatoen for LP'en.
     * 
     * @return Udgivelsesdato som en String.
     */
    public String getPublicationDate() {
        return publicationDate;
    }

    /**
     * Henter listen over kopier af LP'en.
     * 
     * @return Liste over LPCopy objekter.
     */
    public ArrayList<LPCopy> getListCopy() {
        return listCopy;
    }

    /**
     * Tilføjer en LPCopy til listen over kopier.
     * 
     * @param lc LPCopy objektet der skal tilføjes.
     */
    public void addLPCopy(LPCopy lc) {
        listCopy.add(lc);
    }
}
