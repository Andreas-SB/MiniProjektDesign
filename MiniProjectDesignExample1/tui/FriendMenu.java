package tui;
import java.util.Scanner;
import model.Friend;
import controller.FriendController;



public class FriendMenu
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class FriendMenu
     */
    public FriendMenu()
    {
        // initialise instance variables

    }

    public void start() {
        friendMenu();
    }

    private void friendMenu() {
        boolean running = true;
        while (running) {
            int choice = writeFriendMenu();
            switch (choice) {
                case 1:
                    System.out.println(" (1) Opret ven");
                    createFriend();
                    break;
                case 2: 
                    System.out.println(" (2) Søg efter telefonnummer");
                    Friend friend = findFriend();
                     if (friend == null){
                        System.out.println("Ven er ikke fundet");
                    }
                    else{
                        describeFriend(friend);
                    }
                    
                    break;
                case 0:
                    System.out.println(" (0) Tilbage");
                    running = false;
                    break;
                default:
                    System.out.println("En uforklarlig fejl er sket med choice = " + choice);
                    break;
            }
        }
    }

    private int writeFriendMenu() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("****** Venne menu  ******");
        System.out.println(" (1) Opret ven");
        System.out.println(" (2) Søg efter telefonnummer");
        System.out.println(" (0) Tilbage");
        System.out.print("\n Vælg:");
        int choice = getIntegerFromUser(keyboard);
        return choice;
    }

    private int getIntegerFromUser(Scanner keyboard) {
        while (!keyboard.hasNextInt()) {
            System.out.println("Input skal være et tal - prøv igen");
            keyboard.nextLine();
        }
        return keyboard.nextInt();
    }
    
    private Friend findFriend() {
        String phone= inputFriendPhone();
        FriendController controller = new FriendController();      
        Friend friend = controller.findFriend(phone);
        return friend;
    }
    
    private void createFriend(){
        String name = inputFriendName();
        String address = inputFriendAddress();
        String postalCode = inputFriendPostalCode();
        String city = inputFriendCity();
        String phone = inputFriendPhone();
        FriendController controller = new FriendController();
        Friend friend = controller.createFriend(name, address, postalCode,city, phone);
        System.out.println("Ven lavet: " + friend.getName());
    }
    private String inputFriendName() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast navnet på din ven:  ");
        String name = keyboard.nextLine();
        return name;
    }
    private String inputFriendAddress() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast addressen på din ven:  ");
        String address = keyboard.nextLine();
        return address;
    }
    private String inputFriendPostalCode() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast postnummeret på din ven:  ");
        String postalCode = keyboard.nextLine();
        return postalCode;
    }
    private String inputFriendCity() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast byen din ven bor i:  ");
        String city = keyboard.nextLine();
        return city;
    }
    private String inputFriendPhone() {   
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Indtast din vens telefonnummer:  ");
        String phone = keyboard.nextLine();
        return phone;
    }
    
    public void describeFriend(Friend friend){
        System.out.println("Ven er fundet");
        System.out.println("Navn på ven er: " + friend.getName());
        System.out.println("Addressen på ven er: " + friend.getAddress());
        System.out.println("Postnummer på ven er: " + friend.getPostalCode());
        System.out.println("Byen ven bor i er: " + friend.getCity());
        System.out.println("Vens telefonnummer er: " + friend.getPhone());
    }
    
}
