package com.lab3a;

/**
 * Podstawowe operacje na klasach
 * @author Lukasz Kaczynski
 * @version 1.1 01.04.2022
 */
public class Point {
    int x;
    int y;

    /**
     * Inicjacja zmiennych domyslnych
     */
    public Point(){
        this.x=0;
        this.y=0;
    }

    /**
     * Inicjalizacja podanych zmiennych
     * @param x liczba naturalna
     * @param y liczba naturalna
     */
    public Point(int x, int y){
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
     * @return Nazwa.klasy(x,y)
     */
    @Override public String toString(){
        return (this.getClass().getName() + "(" + x + "," + y + ")");
    }
}
