package com.lab8a;

import com.lab3a.Punkt2D;

/**
 * Polimorfizm, rzutowanie
 * @author Lukasz Kaczynski
 * @version 1.1 06.05.2022
 */
public class Punkt3D extends Punkt2D{
    private int z;

    /**
     * Inicjacja zmiennych domyslnych
     */
    public Punkt3D(){
        super();
        this.z = 0;
    }

    /**
     * Inicjalizacja podanych zmiennych
     * @param x liczba naturalna
     * @param y liczba naturalna
     * @param z liczba naturalna
     */
    public Punkt3D(int x, int y, int z){
        super(x,y);
        this.z = z;
    }

    /**
     *
     * @return wartosc z
     */
    public int getZ(){
        return this.z;
    }

    /**
     * Ustawia nowa wartosc z
     * @param z liczba naturalna
     */
    public void setZ(int z){
        this.z = z;
    }

    /**
     *
     * @return tablica zmiennych liczbowych przechowujaca koordynaty punktu
     */
    public int[] getCoordinates(){
        int[] cords = {this.getX(), this.getY(), this.z};
        return cords;
    }

    /**
     *
     * @return Nazwa.klasy(x),(y),(z)
     */
    @Override
    public String toString(){
        return (super.toString() + ",(" + this.z + ")");
    }
}
