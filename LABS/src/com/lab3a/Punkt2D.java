package com.lab3a;

/**
 * Podstawowe operacje na klasach
 * @author Lukasz Kaczynski
 * @version 1.1 01.04.2022
 */
public class Punkt2D implements Punkt{
    private int x;
    private int y;

    /**
     * Inicjacja zmiennych domyslnych
     */
    public Punkt2D(){
        this.x=0;
        this.y=0;
    }

    /**
     * Inicjalizacja podanych zmiennych
     * @param x liczba naturalna
     * @param y liczba naturalna
     */
    public Punkt2D(int x, int y){
        this.x=x;
        this.y=y;
    }

    /**
     *
     * @return wartosc x
     */
    public int getX(){
        return this.x;
    }

    /**
     *
     * @return wartosc y
     */
    public int getY(){
        return this.y;
    }

    /**
     * Ustawia nowa wartosc x
     * @param x liczba naturalna
     */
    public void setX(int x){
        this.x = x;
    }

    /**
     * Ustawia nowa wartosc y
     * @param y liczba naturalna
     */
    public void setY(int y){
        this.y = y;
    }

    /**
     *
     * @return tablica zmiennych liczbowych przechowujaca koordynaty punktu
     */
    public int[] getCoordinates(){
        int[] cords = {this.x, this.y};
        return cords;
    }

    /**
     *
     * @return Nazwa.klasy(x,y)
     */
    @Override public String toString(){
        return (this.getClass().getName() + " (" + x + "),(" + y + ")");
    }
}
