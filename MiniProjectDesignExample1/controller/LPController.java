package controller;
import model.LP;
import model.LPContainer;


/**
 * Write a description of class LPController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LPController
{
    // instance variables - replace the example below with your own
    
    public LPController()
    {
        // initialise instance variables
    }

    public LP createLP(String barcode, String title, String artist,String publicationDate){
        LP l = new LP(barcode, title, artist, publicationDate);
        LPContainer instance = LPContainer.getUniqueInstance();
        instance.addLP(l);
        return l;
    }
}
