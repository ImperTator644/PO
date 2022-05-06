package com.lab8c;

public class Document implements PrinterService {
    String description;
    public Document(){
        this.description = "Document";
    }

    public void print(){
        System.out.println(description);
    }
}
