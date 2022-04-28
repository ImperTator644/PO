package com.lab1_b;

/**
 * Zawiera metody wykonujace podstawowe operacje arytmetyczne
 */
public class OpAr {
    /**
     *
     * @param x podane przez uzytkownika
     * @param y podane przez uzytkownika
     * @return wynik dodawania x y
     */
    public static double addXY(double x, double y){
        return x+y;
    }
    /**
     *
     * @param x podane przez uzytkownika
     * @param y podane przez uzytkownika
     * @return wynik odejmowania x y
     */
    public static double subXY(double x, double y){
        return x-y;
    }
    /**
     *
     * @param x podane przez uzytkownika
     * @param y podane przez uzytkownika
     * @return wynik mnozenia x y
     */
    public static double mulXY(double x, double y){
        return x*y;
    }
    /**
     *
     * @param x podane przez uzytkownika
     * @param y podane przez uzytkownika
     * @return wynik dzielenia x y
     */
    public static double divXY(double x, double y){
        return x/y;
    }
    /**
     *
     * @param x podane przez uzytkownika
     * @param y podane przez uzytkownika
     * @return wynik modulo x y rzutowany do int
     */
    public static double modXY(double x, double y){
        return (int)x%y;
    }
    /**
     *
     * @param x podane przez uzytkownika
     * @param y podane przez uzytkownika
     * @return wynik potegowania x y
     */
    public static double powXY(double x, double y){
        return Math.pow(x,y);
    }
    /**
     *
     * @param x podane przez uzytkownika
     * @param y podane przez uzytkownika
     * @return wynik pierwiastkowania x y
     */
    public static double sqrtXY(double x, double y){
        return Math.pow(x,1.0/y);
    }
}
