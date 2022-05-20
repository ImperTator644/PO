package com.lab10a;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;

        number = scanner.nextInt();
        if (number > 999) throw new ToLargeIntegerException("To large integer");
    }
}
