package com.lab3b;

/**
 * Describes a person.
 */
public class Person {

    protected String name;
    protected Address address;


    /**
     *
     * @param name the name
     * @param street the street
     * @param zipcode the zipcode
     * @param city the city
     */
    public Person(String name, String street, String zipcode, String city) {
        address = new Address(street, zipcode, city);
        this.name = name;
    }

    /**
     * Creates a person.
     *
     * @param name    the name
     * @param address the address
     */
    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setAddress(String street, String zipcode, String city) {
        this.address.setStreet(street);
        this.address.setZipcode(zipcode);
        this.address.setCity(city);
    }

    /**
     * Formats information in single line.
     *
     * @return a string suitable for printing on screen.
     */
    @Override
    public String toString() {
        return name + " [" + address.toString() + "]";
    }

    /**
     * Formats the person's name and address for mailing.
     *
     * @return a string suitable for printing on a mailing label
     */
    public String formatForMailing() {
        return name + "\n" + address.formatForMailing();
    }
}