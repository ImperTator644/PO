package com.lab6a;

/**
 * Deklaruje metody do obliczania pola i obwodu figur geometrycznych
 */
public interface Figura {
    double obliczObwod(double...boki);
    double obliczPowierzchnie(double h, double...boki);
}
