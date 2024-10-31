package model;

/**
 * Friend repræsenterer en ven med tilhørende oplysninger som navn,
 * adresse, postnummer, by og telefonnummer.
 * 
 * @author Gruppe 2 
 * @version 0.1.0
 */
public class Friend {
    // Instansvariabler
    private String name;        // Vennens navn
    private String address;     // Vennens adresse
    private String postalCode;  // Vennens postnummer
    private String city;        // Vennens by
    private String phone;       // Vennens telefonnummer

    /**
     * Konstruktør for objekter af klassen Friend.
     * Initialiserer instansvariablerne med de angivne værdier.
     * 
     * @param name Vennens navn.
     * @param address Vennens adresse.
     * @param postalCode Vennens postnummer.
     * @param city Vennens by.
     * @param phone Vennens telefonnummer.
     */
    public Friend(String name, String address, String postalCode, String city, String phone) {
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.phone = phone;
    }

    /**
     * Henter vennens navn.
     * 
     * @return Vennens navn.
     */
    public String getName() {
        return name;
    }

    /**
     * Henter vennens adresse.
     * 
     * @return Vennens adresse.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Henter vennens postnummer.
     * 
     * @return Vennens postnummer.
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Henter vennens by.
     * 
     * @return Vennens by.
     */
    public String getCity() {
        return city;
    }

    /**
     * Henter vennens telefonnummer.
     * 
     * @return Vennens telefonnummer.
     */
    public String getPhone() {
        return phone;
    }
}
