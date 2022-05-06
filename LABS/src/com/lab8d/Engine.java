package com.lab8d;

public class Engine implements Pojazd {
    private final double spalanie;
    private double stanBaku;
    private double licznik;
    private double zasieg;
    public enum rodzaj{DIESEL, BENZYNA, ELEKTRYK}
    private final rodzaj nazwa;

    public Engine(double spalanie, double stanBaku, double licznik, rodzaj nazwa){
        this.spalanie = spalanie;
        this.stanBaku = stanBaku;
        this.licznik = licznik;
        this.nazwa = nazwa;
        switch(nazwa){
            case DIESEL, BENZYNA -> this.zasieg = (stanBaku * 100.0) / spalanie;
            case ELEKTRYK -> this.zasieg = spalanie * 100.0;
        }

    }

    //getters
    public double getSpalanie() {
        return spalanie;
    }

    public double getStanBaku() {
        return stanBaku;
    }

    public double getLicznik() {
        return licznik;
    }

    public double getZasieg() {
        return zasieg;
    }

    public String getNazwa(){
        return this.nazwa.toString();
    }

    @Override
    public void jedz(double km){
        switch(this.nazwa){
            case DIESEL, BENZYNA -> {
                if(km >= zasieg){
                    System.out.println("Przejechano " + zasieg + "km");
                    licznik += zasieg;
                    stanBaku = 0.0;
                    zasieg = 0.0;
                }
                else{
                    System.out.println("Przejechano " + km + "km");
                    stanBaku -= (km * spalanie) / 100.0;
                    licznik += km;
                    zasieg = (stanBaku * 100.0) / spalanie;
                }
            }
            case ELEKTRYK -> {
                if(km >= zasieg){
                    System.out.println("Przejechano " + zasieg + "km");
                    licznik += zasieg;
                    zasieg = 0.0;
                }
                else{
                    System.out.println("Przejechano " + km + "km");
                    licznik += km;
                    zasieg -= km;
                }
            }
        }
    }

    @Override
    public void tankuj(double l) {
        switch(this.nazwa){
            case DIESEL, BENZYNA -> {
                stanBaku += l;
                zasieg = (stanBaku * spalanie) / 100.0;
            }
            case ELEKTRYK -> zasieg += (l/spalanie) * 100.0;
        }
    }

    @Override
    public String toString(){
        return ("Licznik = " + getLicznik() + "km" +
                "\nZasieg = " + getZasieg() + "km" +
                "\nStan baku = " + getStanBaku() + "l" +
                "\nSpalanie = " + getSpalanie() + "l/100km");
    }
}
