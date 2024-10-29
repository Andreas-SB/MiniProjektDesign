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
    private int purcahsePrice;
    private String condition;

    /**
     * Constructor for objects of class LPCopy
     */
    public LPCopy(String serialNumber,String purchaseDate,int purcahsePrice,String condition)
    {
        // initialise instance variables
        this.serialNumber = serialNumber;
        this.purchaseDate = purchaseDate;
        this.purcahsePrice = purcahsePrice;
        this.condition = condition;
    }

}
