package controller;
import model.Friend;
import model.FriendContainer;

/**
 * FriendController håndterer operationer relateret til venner.
 * Klassen indeholder metoder til at finde og oprette venne-objekter,
 * som administreres af FriendContainer.
 * 
 * @author Gruppe 2 
 * @version 0.1.0
 */
public class FriendController {
    // Instansvariabel
    private Friend foundFriend;

    /**
     * Konstruktør for FriendController-objektet.
     * Initialiserer instansvariabler, hvis nødvendigt.
     */
    public FriendController() {
        // Instansvariabler initialiseres, om nødvendigt
    }

    /**
     * Søger efter en ven baseret på telefonnummeret.
     * Bruges til at slå en ven op i FriendContainer.
     * 
     * @param phone Telefonnummeret på vennen, der skal findes.
     * @return Det fundne Friend-objekt, eller null hvis ingen ven blev fundet.
     */
    public Friend findFriend(String phone) {
        FriendContainer instance = FriendContainer.getUniqueInstance();
        foundFriend = instance.findFriendByPhone(phone);
        return foundFriend;
    }

    /**
     * Opretter en ny ven og tilføjer denne til FriendContainer.
     * 
     * @param name Navnet på vennen.
     * @param address Adressen på vennen.
     * @param postalCode Postnummeret for vennens adresse.
     * @param city Byen hvor vennen bor.
     * @param phone Telefonnummeret til vennen.
     * @return Det nyoprettede Friend-objekt.
     */
    public Friend createFriend(String name, String address, String postalCode, String city, String phone) {
        Friend f = new Friend(name, address, postalCode, city, phone);
        FriendContainer instance = FriendContainer.getUniqueInstance();
        instance.addFriend(f);
        return f;
    }
}
