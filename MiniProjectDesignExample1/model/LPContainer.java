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

    /**
     * Constructor for objects of class LPContainer
     */
     public LPContainer()
    {
        // initialise instance variables
        listLPS = new ArrayList<>();
    }
    public void addLP(LP l){
        listLPS.add(l);
    }
    public static LPContainer getUniqueInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new LPContainer();
        }
        return uniqueInstance;
    }
    public LP findLPByName(String name){
        LP lp = null;
        boolean found = false;
        Iterator<LP> iterator = listLPS.iterator();
        while(iterator.hasNext()&& !found){
            LP l = iterator.next();
            if(name.equals(l.getTitle())){
                found = true;
                lp = l;
            }
        
        }
            
        return lp;
    }
}
