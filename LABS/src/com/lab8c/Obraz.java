package com.lab8c;

public class Obraz implements PrinterService {
    String description;
    public Obraz(){
        this.description = "Obraz";
    }

    public void print(){
        System.out.println(description);
    }
}
