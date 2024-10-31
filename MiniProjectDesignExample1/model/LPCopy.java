package model;


/**
 * Write a description of class LPCopy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LPCopy
{
    // instance variables - replace the example below with your own
    private String serialNumber;
    private String purchaseDate;
    private String purchasePrice;
    private String condition;

    /**
     * Constructor for objects of class LPCopy
     */
    public LPCopy(String serialNumber,String purchaseDate,String purchasePrice,String condition)
    {
        // initialise instance variables
        this.serialNumber = serialNumber;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
        this.condition = condition;
    }
    public String getSerialNumber(){
        return serialNumber;
    }
    public String getPurchaseDate(){
        return purchaseDate;
    }
    public String getPurchasePrice(){
        return purchasePrice;
    }
    public String getCondition(){
        return condition;
    }
    
    public void describeLPCopy(){
        System.out.println("Serienummer på lp kopi'en er: " + serialNumber);
        System.out.println("Indkøbsdato på lp kopi'en er: " + purchaseDate);
        System.out.println("Indkøbspris på lp kopi'en er: " + purchasePrice);
        System.out.println("Tilstand på lp kopi'en er: " + condition);
    }
}
