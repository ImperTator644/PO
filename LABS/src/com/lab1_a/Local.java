package com.lab1_a;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Klasa zawiera metody zwracajace lokalna date i czas
 */
public class Local {
    /**
     *
     * @return data w formacie (yyyy-mm-dd)
     */
    public static LocalDate getCurrentDate(){
        return LocalDate.now();
    }

    /**
     *
     * @return ciag znakow przechowujacy czas w formacie (HH:mm)
     */
    public static String getLocalTime(){
        LocalTime today = LocalTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        return today.format(dtf);
    }

    public static String getInfo(){
        return "To jest test gita";
    }
}