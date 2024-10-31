package model;
import java.util.ArrayList;
import java.util.Iterator;


/**
 * Write a description of class LPContainer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LPContainer
{
    // instance variables - replace the example below with your own
    private static LPContainer  uniqueInstance;
    private ArrayList<LP>listLPS;
    private ArrayList<LPCopy>listLPCopys;

    /**
     * Constructor for objects of class LPContainer
     */
     private LPContainer()
    {
        // initialise instance variables
        listLPS = new ArrayList<>();
        listLPCopys = new ArrayList<>();
    }
    public void addLP(LP l){
        listLPS.add(l);
    }
    public void addLPCopy(LPCopy lc){
        listLPCopys.add(lc);
    }
    public static LPContainer getUniqueInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new LPContainer();
        }
        return uniqueInstance;
    }
    public LP findLPByTitle(String title){
        LP lp = null;
        boolean found = false;
        Iterator<LP> iterator = listLPS.iterator();
        while(iterator.hasNext()&& !found){
            LP l = iterator.next();
            if(title.equals(l.getTitle())){
                found = true;
                lp = l;
            }
        
        }
            
        return lp;
    }
    public LPCopy findLPCopyByBarcode(String serialNumber){
        LPCopy lpcopy = null;
        boolean found = false;
        Iterator<LPCopy> iterator = listLPCopys.iterator();
        while(iterator.hasNext()&& !found){
            LPCopy lc = iterator.next();
            if(serialNumber.equals(lc.getSerialNumber())){
                found = true;
                lpcopy = lc;
            }
        
        }
            
        return lpcopy;
    }
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
