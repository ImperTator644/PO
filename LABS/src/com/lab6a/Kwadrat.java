package com.lab6a;

/**
 * Zawiera metody do obliczenia pola i obwodu kwadratu
 */
public class Kwadrat implements Figura{
    /**
     *
     * @param boki tablica typu double
     * @return true, jesli jest to kwadrat
     */
    private boolean isRectangleGood(double[] boki){
        if(boki.length>4) {
            System.out.println("Error (za duzo bokow)");
            return false;
        }
        for (double v : boki) {
            if (boki[0] != v) {
                System.out.println("Error (nierowne boki)");
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param boki tablica double zawierajaca dlugosci bokow
     * @return obwod kwadratu
     */
    @Override
    public double obliczObwod(double... boki) {
        if(this.isRectangleGood(boki)) return 4*boki[0];
        else return 0.0;
    }

    /**
     *
     * @param h wysokosc kwadrata (ktora powinna byc taka jak boki)
     * @param boki tablica double zawierajaca dlugosci bokow
     * @return pole kwadratu
     */
    @Override
    public double obliczPowierzchnie(double h, double... boki) {
        if(this.isRectangleGood(boki) && h==boki[0]) return h*boki[0];
        else return 0.0;
    }
}
