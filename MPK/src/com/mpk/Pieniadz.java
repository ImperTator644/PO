package com.mpk;

/**
 * Klasa pieniadz
 * Posiada swoja wartosc i nazwe
 *
 */
public class Pieniadz {
    private double wartosc;
    private final String nazwa;

    /**
     * Na podstawie nazwy tworzy nowy obiekt
     * @param nazwa nazwa pieniadza
     */
    public Pieniadz(String nazwa){
        StringBuilder sb = new StringBuilder();
        char temp=' ';
        for(int i=0;i<nazwa.length();i++){
            if(Character.isDigit(nazwa.charAt(i))) sb.append(nazwa.charAt(i));
            else if(nazwa.charAt(i)=='g') temp='g';
        }
        wartosc=Double.parseDouble(sb.toString());
        if(temp=='g') wartosc/=100.0;
        this.nazwa=nazwa;
    }

    public double getWartosc(){
        return this.wartosc;
    }

    @Override public String toString(){
        return ("[nazwa = "+this.nazwa+"]");
    }
}
