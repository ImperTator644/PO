package com.lab8d;

import java.awt.*;

public abstract class Vehicle implements Pojazd{
    private final Engine silnik;
    private String nrRej;
    private final int vin;
    private Color kolor;
    private int cena;

    public Vehicle(Engine silnik, String nrRej, int vin, Color kolor, int cena){
        this.silnik = silnik;
        this.nrRej = nrRej;
        this.vin = vin;
        this.kolor = kolor;
        this.cena = cena;
    }

    public String getNrRej() {
        return nrRej;
    }

    public int getVin() {
        return vin;
    }

    public Color getKolor() {
        return kolor;
    }

    public int getCena() {
        return cena;
    }

    public void setNrRej(String nrRej) {
        this.nrRej = nrRej;
    }

    public void setKolor(Color kolor) {
        this.kolor = kolor;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }


    @Override
    public void jedz(double km) {
        this.silnik.jedz(km);
        System.out.println("Aktualny stan: ");
        System.out.println(this.silnik);
    }

    @Override
    public void tankuj(double l) {
        this.silnik.tankuj(l);
        System.out.println("Aktualny stan: ");
        System.out.println(this.silnik);
    }

    @Override
    public String toString(){
        return ("Silnik: " + this.silnik.getNazwa() +
                "\n" + this.silnik.toString() +
                "\nNr rej: " + getNrRej() +
                "\nNr VIN: " + getVin() +
                "\nKolor: " + getKolor().toString() +
                "\nCena: " + getCena() + "zl \n ----------------------------\n");
    }
}
