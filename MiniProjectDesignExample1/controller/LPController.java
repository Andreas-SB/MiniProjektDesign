package controller;
import model.LP;
import model.LPCopy;
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
        private LP foundLP;
        
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
    public LPCopy createLPCopy(String serialNumber, String purchaseDate, String purchasePrice,String condition){
        LPCopy lc = new LPCopy(serialNumber, purchaseDate, purchasePrice, condition);
        LPContainer instance = LPContainer.getUniqueInstance();
        instance.addLPCopy(lc);
        return lc;
    }
    public LP findLP(String title){
        LPContainer instance = LPContainer.getUniqueInstance();
        foundLP = instance.findLPByTitle(title);
        return foundLP;
    }
}
