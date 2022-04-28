package com.lab3c;

public class Samolot {
    private final double BURN = 5.0;
    private double range;
    private double fuel;

    public Samolot(){
        fuel=0;
        range=0;
    }

    public Samolot(double fuel){
        this.fuel = fuel;
        this.range = fuel/BURN;
    }

    //getters and setters

    public double getFuel(){
        return fuel;
    }

    public double getRange(){
        return range;
    }

    public void fill(){
        this.fuel+=1000.0;
        range = this.fuel/BURN;
    }

    public void fill(double fuel){
        this.fuel+=fuel;
        range = this.fuel/BURN;
    }

    @Override public String toString(){
        return ("Fuel: " + getFuel() + " l\nRange: " + getRange() + "km");
    }
}
