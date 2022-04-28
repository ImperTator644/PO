package com.mpk;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Zawiera funkcje do modyfikacji klienta
 * Dziedziczy po klasie Osoba
 */
public final class Klient extends Osoba{  // zastosowany mechanizm dziedziczenia
    private final LocalDate WRONG_DATE=LocalDate.parse("0000-01-01");
    private final short WIEK_EMERYTALNY = 65;
    private final ArrayList<Bilet> tickets = new ArrayList<>(); //zastosowany mechanizm kompozycji
    public Portfel portfel; //zastosowany mechanizm kompozycji
    private boolean ulga;
    private boolean student;

    /**
     * Tworzy klienta o podanych danych
     * @param name imie klienta
     * @param surname nazwisko klienta
     * @param dateOfBirth data urodzenia klienta
     * @param student czy klient jest studentem
     */
    public Klient(String name, String surname, String dateOfBirth, boolean student){
        super(name, surname, dateOfBirth);
        this.student=student;
        if(getDateOfBirth().isEqual(WRONG_DATE)){
            System.out.println("WRONG DATE");
            ulga=false;
        }
        else if(getDateOfBirth().plusYears(18).isBefore(LocalDate.now())) ulga=true;
        else if(getDateOfBirth().plusYears(WIEK_EMERYTALNY).isBefore(LocalDate.now())) ulga=true;

        else ulga=student;
        portfel = new Portfel();
    }

    public boolean getStudent(){
        return student;
    }
    public void setStudent(boolean student){
        this.student=student;
    }

    /**
     *
     * @return zwraca true, jesli klientowi przysluguje ulga
     */
    public boolean checkUlga(){
        if(getDateOfBirth().isEqual(WRONG_DATE)){
            System.out.println("WRONG DATE");
            ulga=false;
        }
        else if(getDateOfBirth().plusYears(18).isAfter(LocalDate.now())) this.ulga=true;
        else if(getDateOfBirth().plusYears(WIEK_EMERYTALNY).isBefore(LocalDate.now())) this.ulga=true;

        else this.ulga=this.student;
        return ulga;
    }

    /**
     * Dodaje bilet do listy biletow klienta
     * @param bilet obiekt bilet
     * @return true, jesli obiek zostal dodany pomyslnie
     */
    public boolean addTicket(Bilet bilet){
        if(this.portfel.subMoney(bilet.getKoszt())) {
            tickets.add(bilet);
            return true;
        }
        else return false;
    }

    /**
     *
     * @return ciag znakow zawierajacy liste biletow klienta
     */
    public String showTickets(){
        StringBuilder sb = new StringBuilder();
        for(Bilet b:tickets){
            sb.append(b);
        }
        return sb.toString();
    }

    /**
     * Wyswietla na ekranie informacje na temat klienta
     */
    public void showInfo(){
        JOptionPane.showMessageDialog(null, this.toString(), "Klient info", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     *
     * @return ciag znakow z informacjami na temat klienta
     */
    @Override
    public String toString(){
        return (super.toString() + "[ULGA = "+ulga+"]\n"+portfel+
                "\nAktywne bilety:\n" + showTickets());
    }
}
