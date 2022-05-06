package com.lab8c;

public class Dzwiek implements PrinterService {
    String description;
    public Dzwiek(){
        this.description = "Dzwiek";
    }

    public void print(){
        System.out.println(description);
    }
}
