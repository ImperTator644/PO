package com.mpk;

import java.time.DateTimeException;
import java.time.LocalDate;

/**
 * Klasa zawierajaca metody modyfikujace podstawowe dane na temat klientow
 */
public abstract class Osoba {
    private final String name;
    private final String surname;
    private LocalDate dateOfBirth;

    Osoba(String name, String surname, String dateOfBirth){
        this.name=name;
        this.surname=surname;
        try {
            this.dateOfBirth = LocalDate.parse(dateOfBirth);
        }
        catch(DateTimeException dte){
            System.out.println("WRONG DATE");
            this.dateOfBirth = LocalDate.parse("0000-01-01");
        }
    }

    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public LocalDate getDateOfBirth(){
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth){
        try {
            this.dateOfBirth = LocalDate.parse(dateOfBirth);
        }
        catch(DateTimeException dte){
            System.out.println("WRONG DATE");
        }
    }
    @Override
    public String toString(){
        return ("["+ name + " " + surname + ", " + dateOfBirth + "]");
    }
}
