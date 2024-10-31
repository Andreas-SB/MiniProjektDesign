package controller;
import model.Friend;
import model.FriendContainer;

/**
 * FriendController håndterer operationer relateret til venner.
 * Denne klasse giver funktioner til at finde og oprette venner.
 * 
 * @author gruppe 2 
 * @version 0.1.0
 */
public class FriendController {
    // Instansvariabler
    private Friend foundFriend;

    /**
     * Konstruktør for objekter af klassen FriendController.
     * Initialiserer instansvariablerne.
     */
    public FriendController() {
        // Initialiserer instansvariabler
    }

    /**
     * Finder en ven baseret på telefonnummer.
     * 
     * @param phone Telefonnummeret på vennen der skal findes.
     * @return Det fundne Friend-objekt eller null hvis ikke fundet.
     */
    public Friend findFriend(String phone) {
        FriendContainer instance = FriendContainer.getUniqueInstance();
        foundFriend = instance.findFriendByPhone(phone);
        return foundFriend;
    }

    /**
     * Opretter en ny ven med de angivne oplysninger.
     * 
     * @param name Navnet på vennen.
     * @param address Adressen på vennen.
     * @param postalCode Postnummeret for vennens adresse.
     * @param city Byen hvor vennen bor.
     * @param phone Telefonnummeret til vennen.
     * @return Det oprettede Friend-objekt.
     */
    public Friend createFriend(String name, String address, String postalCode, String city, String phone) {
        Friend f = new Friend(name, address, postalCode, city, phone);
        FriendContainer instance = FriendContainer.getUniqueInstance();
        instance.addFriend(f);
        return f;
    }
}
