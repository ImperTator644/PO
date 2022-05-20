package com.lab10b;

import java.util.Scanner;

public class Pierwiastek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double number;
        byte proba = 0;

        while(proba<3){
            number = scanner.nextDouble();
            try {
                if(number<0) {
                    proba++;
                    throw new IllegalArgumentException("Negative number can't be squared");
                }
                proba=3;
                System.out.println(Math.sqrt(number));
            }
            catch(IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            }
        }
    }
}
