package controller;
import model.Friend;
import model.FriendContainer;

/**
 * Write a description of class FriendController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FriendController
{
    // instance variables - replace the example below with your own
    
    public FriendController()
    {
        // initialise instance variables

    }
    
    public Friend createFriend(String name, String address, String postalCode,String city, String phone){
        Friend f = new Friend(name, address, postalCode, city, phone);
        FriendContainer instance = FriendContainer.getUniqueInstance();
        instance.addFriend(f);
        return f;
    }
    

}
