package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * FriendContainer er en singleton-klasse, der opbevarer en liste over venner
 * og giver metoder til at tilføje og finde venner baseret på navn eller telefonnummer.
 * 
 * @author Gruppe 2 
 * @version 0.1.0
 */
public class FriendContainer {
    // Instansvariabler
    private static FriendContainer uniqueInstance; // Singleton-instans
    private ArrayList<Friend> listFriends; // Liste over venner

    /**
     * Konstruktør for objekter af klassen FriendContainer.
     * Initialiserer listen over venner.
     */
    public FriendContainer() {
        listFriends = new ArrayList<>();
    }

    /**
     * Henter den unikke instans af FriendContainer.
     * 
     * @return Den unikke instans af FriendContainer.
     */
    public static FriendContainer getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new FriendContainer();
        }
        return uniqueInstance;
    }

    /**
     * Tilføjer en ven til listen.
     * 
     * @param f Venen, der skal tilføjes.
     */
    public void addFriend(Friend f) {
        listFriends.add(f);
    }

    /**
     * Finder en ven baseret på navn.
     * 
     * @param name Navnet på den ven, der skal findes.
     * @return Den fundne ven, eller null hvis ingen ven blev fundet.
     */
    public Friend findFriendByName(String name) {
        Friend friend = null;
        boolean found = false;
        Iterator<Friend> iterator = listFriends.iterator();
        while (iterator.hasNext() && !found) {
            Friend f = iterator.next();
            if (name.equals(f.getName())) {
                found = true;
                friend = f;
            }
        }
        return friend;
    }

    /**
     * Finder en ven baseret på telefonnummer.
     * 
     * @param phone Telefonnummeret på den ven, der skal findes.
     * @return Den fundne ven, eller null hvis ingen ven blev fundet.
     */
    public Friend findFriendByPhone(String phone) {
        Friend friend = null;
        boolean found = false;
        Iterator<Friend> iterator = listFriends.iterator();
        while (iterator.hasNext() && !found) {
            Friend f = iterator.next();
            if (phone.equals(f.getPhone())) {
                found = true;
                friend = f;
            }
        }
        return friend;
    }
}
