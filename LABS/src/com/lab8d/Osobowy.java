package com.lab8d;

import java.awt.*;

public class Osobowy extends Vehicle{
    private final String marka;
    private final String model;
    private final double secTo100;
    public enum rodzaj{Hatchback, Kombi, Sedan, Liftback, Van, Suv}
    private final rodzaj nazwa;

    public Osobowy(Engine silnik, String nrRej, int vin, Color kolor, int cena, String marka, String model, double secTo100, rodzaj nazwa){
        super(silnik, nrRej, vin, kolor, cena);
        this.marka = marka;
        this.model = model;
        this.secTo100 = secTo100;
        this.nazwa = nazwa;
    }

    public String getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }

    public double getSecTo100() {
        return secTo100;
    }

    public rodzaj getNazwa() {
        return nazwa;
    }

    @Override
    public void jedz(double km){
        System.out.println(getMarka() + " " + getModel() + " jedzie");
        super.jedz(km);
    }

    @Override
    public void tankuj(double l){
        System.out.println(getMarka() + " " + getModel() + " tankuje " + l + "l");
        super.tankuj(l);
    }

    @Override
    public String toString(){
        return (getMarka() + " " + getModel() +
                "\n" + super.toString());
    }
}
