package com.lab8b;

public class PdfDocument extends DocumentItem{

    public PdfDocument(){
        super("PDF");
    }

    public String getDescription(){
        return (super.getDescription() + " plik");
    }
}
