package com.lab8a;

/**
 * Polimorfizm, rzutowanie
 * @author Lukasz Kaczynski
 * @version 1.1 06.05.2022
 */
public class Punkt3DzEtykieta extends Punkt3D{
    private static char nextEtykieta = 'A';
    private char etykieta;

    /**
     * Inicjacja zmiennych domyslnych
     */
    public Punkt3DzEtykieta(){
        super();
        etykieta = nextEtykieta;
        nextEtykieta++;
    }

    /**
     * Inicjalizacja podanych zmiennych
     * @param x liczba naturalna
     * @param y liczba naturalna
     * @param z liczba naturalna
     * @param etykieta zmienna znakowa
     */
    public Punkt3DzEtykieta(int x, int y, int z, char etykieta){
        super(x,y,z);
        this.etykieta = etykieta;
    }

    /**
     *
     * @return etykieta punktu
     */
    public char getEtykieta(){
        return etykieta;
    }

    /**
     * Ustawia etykiete punktu
     * @param etykieta zmienna znakowa
     */
    public void setEtykieta(char etykieta){
        this.etykieta = etykieta;
    }

    /**
     *
     * @return Nazwa.klasy(x),(y),(z), [ etykieta ]
     */
    @Override
    public String toString(){
        return (super.toString() + ", [ " + this.etykieta + " ]");
    }
}
