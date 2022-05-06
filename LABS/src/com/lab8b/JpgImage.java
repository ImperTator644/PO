package com.lab8b;

public class JpgImage extends DocumentItem{

    public JpgImage(){
        super("JPG");
    }

    public String getDescription(){
        return (super.getDescription() + " image");
    }
}
