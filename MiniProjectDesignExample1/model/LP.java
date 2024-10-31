package model;
import java.util.ArrayList;


/**
 * Write a description of class LP here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LP
{
    // instance variables - replace the example below with your own
    private String barcode;
    private String title;
    private String artist;
    private String publicationDate;
    private ArrayList<LPCopy> listCopy;

    /**
     * Constructor for objects of class LP
     */
    public LP(String barcode, String title, String artist, String publicationDate)
    {
        // initialise instance variables
        this.barcode = barcode;
        this.title = title;
        this.artist = artist;
        this.publicationDate = publicationDate;
        this.listCopy = new ArrayList<>();
    }
    public String getBarcode(){
        return barcode;
    }
    public String getTitle(){
        return title;
    }
    public String getArtist(){
        return artist;
    }
    public String getPublicationDate(){
        return publicationDate;
    }
    
    public void describeLP(){
        System.out.println("Stregekoden til lp'en er: " + barcode);
        System.out.println("Titlen på lp'en er: " + title);
        System.out.println("kunstner på lp'en er: " + artist);
        System.out.println("Udgivelsesdato på lp'en er: " + publicationDate);
    }
    
    public ArrayList<LPCopy> getListCopy() {
        return listCopy;
    }
    public void addLPCopy(LPCopy lc){
        listCopy.add(lc);
    }
    
}
