package com.mpk;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Klasa zawiera metody do obslugi biletow
 */
public class Bilet {
    private final LocalDateTime dataZakupu;
    private final LocalDateTime wygasa;
    private final String ulga;
    private final double koszt;
    private final String nazwa;

    // getters
    public LocalDateTime getDataZakupu() {
        return dataZakupu;
    }

    public LocalDateTime getWygasa() {
        return wygasa;
    }

    public String getUlga() {
        return ulga;
    }

    public double getKoszt() {
        return koszt;
    }

    /**
     * Tworzy nowy bilet o podanych parametrach
     * @param rodzaj rodzaj biletu (1,2,3,4)
     * @param ulga "U" jesli ulgowy
     */
    public Bilet(int rodzaj, String ulga){
        dataZakupu = LocalDateTime.now();
        switch (rodzaj){
            case 1 -> {
                if(ulga.equals("U"))koszt= 8.5;
                else koszt= 17.0;
                wygasa = dataZakupu.plusDays(1);
                nazwa = "24 godziny";
            }
            case 2 -> {
                if(ulga.equals("U"))koszt= 2.0;
                else koszt= 4.0;
                wygasa = dataZakupu.plusMinutes(20);
                nazwa = "20 min";
            }
            case 3 -> {
                if(ulga.equals("U"))koszt= 3.0;
                else koszt= 6.0;
                wygasa = dataZakupu.plusHours(1);
                nazwa = "60 min";
            }
            case 4 -> {
                if(ulga.equals("U"))koszt= 4.0;
                else koszt= 8.0;
                wygasa = dataZakupu.plusMinutes(90);
                nazwa = "90 min";
            }
            default -> {
                koszt=0.0;
                wygasa = dataZakupu;
                nazwa = "";
            }
        }
        this.ulga=ulga;
    }

    @Override public String toString(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return ("\n" + nazwa + " " + ulga + " " + koszt + "\n"
        + "Rozpoczeto: " + dataZakupu.format(dtf) + "\nWygasa: " + wygasa.format(dtf));
    }
}
