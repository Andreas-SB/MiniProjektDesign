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
    public String getTitle(){
        return title;
    }
    public void addLPCopy(LPCopy lc){
        listCopy.add(lc);
    }
    
}
