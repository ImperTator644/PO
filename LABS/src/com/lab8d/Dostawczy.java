package com.lab8d;

import java.awt.*;

public class Dostawczy extends Vehicle{
    private final String marka;
    private final int ladownosc;

    public Dostawczy(Engine silnik, String nrRej, int vin, Color kolor, int cena, String marka, int ladownosc){
        super(silnik, nrRej, vin, kolor, cena);
        this.marka = marka;
        this.ladownosc = ladownosc;
    }

    public String getMarka() {
        return marka;
    }

    public int getLadownosc() {
        return ladownosc;
    }

    @Override
    public void jedz(double km){
        System.out.println(getMarka() + " jedzie");
        super.jedz(km);
    }

    @Override
    public void tankuj(double l){
        System.out.println(getMarka() + " tankuje " + l + "l");
        super.tankuj(l);
    }

    @Override
    public String toString(){
        return (getMarka() +
                "\n" + super.toString());
    }
}
