package com.lab6a;

import java.util.Arrays;

/**
 * Zawiera metody do obliczenia pola i obwodu trojkata
 */
public class Trojkat implements Figura{
    /**
     *
     * @param boki tablica typu double
     * @return true, jesli jest to trojkat
     */
    private boolean isTriangleGood(double[] boki){
        if(boki.length!=3) {
            System.out.println("Error (zla liczba bokow)");
            return false;
        }
        else if (boki[0]+boki[1] <= boki[2]
                || boki[1]+boki[2] <= boki[0]
                || boki[0]+boki[2] <= boki[1]){
            System.out.println("Error (zle dlugosci bokow)");
            return false;
        }
        return true;
    }

    /**
     * Sprawdza, czy wysokosc mniej wiecej zgadza sie z dlugoscia bokow
     * @param h double wysokosc trojkata
     * @param boki tablica double zawierajaca dlugosci bokow
     * @return true, jesli wysokosc jest mozliwa
     */
    private boolean isHeightGood(double h, double[] boki){
        if(Math.sqrt(boki[1] * boki[1] - h*h) > boki[0]
        || Math.sqrt(boki[2] * boki[2] - h*h) > boki[0]){
            System.out.println("Error (zla wysokosc)");
            return false;
        }
        else return true;
    }

    /**
     *
     * @param boki tablica double zawierajaca dlugosci bokow
     * @return obwod trojkata
     */
    @Override
    public double obliczObwod(double... boki) {
        if(this.isTriangleGood(boki)){
            return Arrays.stream(boki).sum();
        }
        else return 0.0;
    }

    /**
     *
     * @param h wysokosc trojkata
     * @param boki tablica double zawierajaca dlugosci bokow
     * @return pole trojkata
     */
    @Override
    public double obliczPowierzchnie(double h, double... boki) {
        if(this.isTriangleGood(boki) && this.isHeightGood(h, boki)){
            return (h*boki[0])/2;
        }
        else return 0.0;
    }
}
