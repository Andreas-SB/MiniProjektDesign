package tui;

import java.util.Scanner;
import model.Friend;
import controller.FriendController;

/**
 * FriendMenu-klassen repræsenterer menuen til håndtering af venner, der giver brugeren 
 * mulighed for at oprette nye venner og søge efter eksisterende venner baseret på 
 * telefonnummer.
 *
 * Forfatter: Gruppe 2 
 * Version: 0.1.0
 */
public class FriendMenu {
    // Instansvariabler

    /**
     * Konstruktør for FriendMenu-objektet.
     * Initialiserer instansvariablerne, hvis det er nødvendigt.
     */
    public FriendMenu() {
        // Initialiserer instansvariabler
    }

    /**
     * Starter venne-menuen.
     */
    public void start() {
        friendMenu();
    }

    /**
     * Viser venne-menuen og håndterer brugerens valg.
     * Kører indtil brugeren vælger at gå tilbage.
     */
    private void friendMenu() {
        boolean running = true;
        while (running) {
            int choice = writeFriendMenu();
            switch (choice) {
                case 1:
                    System.out.println(" (1) Opret ven");
                    createFriend(); // Opretter en ny ven
                    break;
                case 2: 
                    System.out.println(" (2) Søg efter telefonnummer");
                    Friend friend = findFriend(); // Finder ven efter telefonnummer
                    if (friend == null) {
                        System.out.println("Ven er ikke fundet");
                    } else {
                        describeFriend(friend); // Beskriver ven
                    }
                    break;
                case 0:
                    System.out.println(" (0) Tilbage");
                    running = false; // Stopper menuen
                    break;
                default:
                    System.out.println("En uforklarlig fejl er sket med choice = " + choice);
                    break;
            }
        }
    }

    /**
     * Viser venne-menuens valgmuligheder og læser brugerens valg.
     *
     * @return int - Brugerens valg som et heltal.
     */
    private int writeFriendMenu() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("****** Venne menu  ******");
        System.out.println(" (1) Opret ven");
        System.out.println(" (2) Søg efter telefonnummer");
        System.out.println(" (0) Tilbage");
        System.out.print("\n Vælg:");
        int choice = getIntegerFromUser(keyboard); // Får brugerens valg
        return choice;
    }

    /**
     * Metode til at få et heltal fra brugeren.
     *
     * @param keyboard Scanner-objektet til indlæsning af brugerinput.
     * @return int - Brugerens input som et heltal.
     */
    private int getIntegerFromUser(Scanner keyboard) {
        while (!keyboard.hasNextInt()) {
            System.out.println("Input skal være et tal - prøv igen");
            keyboard.nextLine();
        }
        return keyboard.nextInt(); // Returnerer det indlæste heltal
    }
    
    /**
     * Finder en ven baseret på telefonnummer.
     *
     * @return Friend - Ven, hvis fundet; ellers null.
     */
    private Friend findFriend() {
        String phone = inputFriendPhone(); // Indlæser telefonnummer
        FriendController controller = new FriendController();      
        Friend friend = controller.findFriend(phone); // Finder ven
        return friend; // Returnerer ven
    }
    
    /**
     * Opretter en ny ven med brugerens input.
     */
    private void createFriend() {
        String name = inputFriendName();
        String address = inputFriendAddress();
        String postalCode = inputFriendPostalCode();
        String city = inputFriendCity();
        String phone = inputFriendPhone();
        FriendController controller = new FriendController();
        Friend friend = controller.createFriend(name, address, postalCode, city, phone); // Opretter ven
        System.out.println("Ven lavet: " + friend.getName());
    }
    
    /**
     * Indlæser navnet på en ven fra brugeren.
     *
     * @return String - Navnet på vennen.
     */
    private String inputFriendName() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast navnet på din ven:  ");
        String name = keyboard.nextLine();
        return name;
    }
    
    /**
     * Indlæser adressen på en ven fra brugeren.
     *
     * @return String - Adressen på vennen.
     */
    private String inputFriendAddress() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast addressen på din ven:  ");
        String address = keyboard.nextLine();
        return address;
    }
    
    /**
     * Indlæser postnummeret på en ven fra brugeren.
     *
     * @return String - Postnummeret på vennen.
     */
    private String inputFriendPostalCode() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast postnummeret på din ven:  ");
        String postalCode = keyboard.nextLine();
        return postalCode;
    }
    
    /**
     * Indlæser byen, hvor en ven bor fra brugeren.
     *
     * @return String - Byen, hvor vennen bor.
     */
    private String inputFriendCity() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast byen din ven bor i:  ");
        String city = keyboard.nextLine();
        return city;
    }
    
    /**
     * Indlæser telefonnummeret på en ven fra brugeren.
     *
     * @return String - Telefonnummeret på vennen.
     */
    private String inputFriendPhone() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast din vens telefonnummer:  ");
        String phone = keyboard.nextLine();
        return phone;
    }
    
    /**
     * Beskriver oplysningerne om en ven.
     *
     * @param friend - Den ven, der skal beskrives.
     */
    public void describeFriend(Friend friend) {
        System.out.println("Ven er fundet");
        System.out.println("Navn på ven er: " + friend.getName());
        System.out.println("Addressen på ven er: " + friend.getAddress());
        System.out.println("Postnummer på ven er: " + friend.getPostalCode());
        System.out.println("Byen ven bor i er: " + friend.getCity());
        System.out.println("Vens telefonnummer er: " + friend.getPhone());
    }
}
