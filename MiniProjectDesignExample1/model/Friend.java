package model;


/**
 * Write a description of class Friend here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Friend
{
    // instance variables - replace the example below with your own
    private String name;
    private String address;
    private String postalCode;
    private String city;
    private String phone;

    /**
     * Constructor for objects of class Friend
     */
    public Friend(String name,String address,String postalCode,String city,String phone)
    {
        // initialise instance variables
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.phone = phone;
    }
    
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public String getPostalCode(){
        return postalCode;
    }
    public String getCity(){
        return city;
    }
    public String getPhone(){
        return phone;
    }

}
