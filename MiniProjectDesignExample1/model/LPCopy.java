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
    private int purchasePrice;
    private String condition;

    /**
     * Constructor for objects of class LPCopy
     */
    public LPCopy(String serialNumber,String purchaseDate,int purchasePrice,String condition)
    {
        // initialise instance variables
        this.serialNumber = serialNumber;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
        this.condition = condition;
    }

}
