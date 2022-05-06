package com.lab8b;

public class WordDocument extends DocumentItem{

    public WordDocument(){
        super("Word");
    }

    public String getDescription(){
        return (super.getDescription() + " document");
    }
}
