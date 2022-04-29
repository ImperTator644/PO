package com.lab6a;

import java.util.Arrays;

/**
 * Zawiera metody do obliczenia pola i obwodu trapezu
 */
public class Trapez implements Figura{
    /**
     *
     * @param boki tablica typu double
     * @return true, jesli ilosc bokow jest prawidlowa
     */
    private boolean isTrapezGood(double[] boki){
        if(boki.length!=4) {
            System.out.println("Error (zla ilosc bokow)");
            return false;
        }
        return true;
    }

    /**
     *
     * @param boki tablica double zawierajaca dlugosci bokow
     * @return obwod trapezu
     */
    @Override
    public double obliczObwod(double... boki) {
        if(this.isTrapezGood(boki)){
            return Arrays.stream(boki).sum();
        }
        else return 0.0;
    }

    /**
     *
     * @param h wysokosc trapezu
     * @param boki tablica double zawierajaca dlugosci bokow
     * @return pole trapezu
     */
    @Override
    public double obliczPowierzchnie(double h, double... boki) {
        if(this.isTrapezGood(boki)) return ((boki[0]+boki[1])*h)/2.0;
        else return 0.0;
    }
}
