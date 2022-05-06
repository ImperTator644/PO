package com.lab8b;

public class ExcelDocument extends DocumentItem{

    public ExcelDocument(){
        super("Excel");
    }

    public String getDescription(){
        return (super.getDescription() + " sheet");
    }
}
