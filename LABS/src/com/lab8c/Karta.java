package com.lab8c;

public class Karta implements PrinterService {
    String description;
    public Karta(){
        this.description = "Karta";
    }

    public void print(){
        System.out.println(description);
    }
}
