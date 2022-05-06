package com.lab8b;

public abstract class DocumentItem {
    private String description;

    public DocumentItem(String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
    }
}
