package model;
import java.util.ArrayList;
import java.util.Iterator;


/**
 * Write a description of class FriendContainer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FriendContainer
{
    // instance variables - replace the example below with your own
    private static FriendContainer  uniqueInstance;
    private ArrayList<Friend>listFriends;

    /**
     * Constructor for objects of class FriendContainer
     */
    public FriendContainer()
    {
        // initialise instance variables
        listFriends = new ArrayList<>();
    }
    public static FriendContainer getUniqueInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new FriendContainer();
        }
        return uniqueInstance;
    }
    public void addFriend(Friend f){
        listFriends.add(f);
    }
    public Friend findFriendByName(String name){
        Friend friend = null;
        boolean found = false;
        Iterator<Friend> iterator = listFriends.iterator();
        while(iterator.hasNext()&& !found){
            Friend f = iterator.next();
            if(name.equals(f.getName())){
                found = true;
                friend = f;
            }
        
        }
            
        return friend;
    }
}
