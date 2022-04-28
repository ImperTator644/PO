package com.mpk;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Klasa obslugujaca obiekty klasy Pieniadz
 * Przechowuje informacje na temat aktualnego stanu portfela poszczegolnych obiektow
 */
public class Portfel {
    private final ArrayList<ArrayList<Pieniadz>> money = new ArrayList<>();

    public Portfel(){
        money.add(new ArrayList<>());
        money.add(new ArrayList<>());
        money.add(new ArrayList<>());
        money.add(new ArrayList<>());
        money.add(new ArrayList<>());
        money.add(new ArrayList<>());
        money.add(new ArrayList<>());
        money.add(new ArrayList<>());
        money.add(new ArrayList<>());
        money.add(new ArrayList<>());
        money.add(new ArrayList<>());
        money.add(new ArrayList<>());
        money.add(new ArrayList<>());
        money.add(new ArrayList<>());
    }

    public void add1gr(int count){
        for(int i=0;i<count;i++) money.get(0).add(new Pieniadz("1gr"));
    }
    public void add2gr(int count){
        for(int i=0;i<count;i++) money.get(1).add(new Pieniadz("2gr"));
    }
    public void add5gr(int count){
        for(int i=0;i<count;i++) money.get(2).add(new Pieniadz("5gr"));
    }
    public void add10gr(int count){
        for(int i=0;i<count;i++) money.get(3).add(new Pieniadz("10gr"));
    }
    public void add20gr(int count){
        for(int i=0;i<count;i++) money.get(4).add(new Pieniadz("20gr"));
    }
    public void add50gr(int count){
        for(int i=0;i<count;i++) money.get(5).add(new Pieniadz("50gr"));
    }
    public void add1zl(int count){
        for(int i=0;i<count;i++) money.get(6).add(new Pieniadz("1zl"));
    }
    public void add2zl(int count){
        for(int i=0;i<count;i++) money.get(7).add(new Pieniadz("2zl"));
    }
    public void add5zl(int count){
        for(int i=0;i<count;i++) money.get(8).add(new Pieniadz("5zl"));
    }
    public void add10zl(int count){
        for(int i=0;i<count;i++) money.get(9).add(new Pieniadz("10zl"));
    }
    public void add20zl(int count){
        for(int i=0;i<count;i++) money.get(10).add(new Pieniadz("20zl"));
    }
    public void add50zl(int count){
        for(int i=0;i<count;i++) money.get(11).add(new Pieniadz("50zl"));
    }
    public void add100zl(int count){
        for(int i=0;i<count;i++) money.get(12).add(new Pieniadz("100zl"));
    }
    public void add200zl(int count){
        for(int i=0;i<count;i++) money.get(13).add(new Pieniadz("200zl"));
    }

    public double stanPortfela(){
        double suma=0;
        for (ArrayList<Pieniadz> pieniadze : money) {
            for (Pieniadz pieniadz : pieniadze) {
                suma += pieniadz.getWartosc();
            }
        }
        suma=Math.round(suma * 100.0)/100.0;
        return suma;
    }

    private void clearPortfel(){
        for(ArrayList<Pieniadz> pieniadze : money){
            pieniadze.clear();
        }
    }

    private void addZl(int zl){
        while(zl>0){
            if(zl>=200) {
                this.add200zl(1);
                zl-=200;
            }
            else if(zl>=100) {
                this.add100zl(1);
                zl-=100;
            }
            else if(zl>=50) {
                this.add50zl(1);
                zl-=50;
            }
            else if(zl>=20) {
                this.add20zl(1);
                zl-=20;
            }
            else if(zl>=10) {
                this.add10zl(1);
                zl-=10;
            }
            else if(zl>=5) {
                this.add5zl(1);
                zl-=5;
            }
            else if(zl>=2) {
                this.add2zl(1);
                zl-=2;
            }
            else {
                this.add1zl(1);
                zl-=1;
            }
        }
    }

    private void addGr(int gr){
        while(gr>0) {
             if (gr >= 50) {
                this.add50gr(1);
                gr -= 50;
            } else if (gr >= 20) {
                this.add20gr(1);
                gr -= 20;
            } else if (gr >= 10) {
                this.add10gr(1);
                gr -= 10;
            } else if (gr >= 5) {
                this.add5gr(1);
                gr -= 5;
            } else if (gr >= 2) {
                this.add2gr(1);
                gr -= 2;
            } else {
                this.add1gr(1);
                gr -= 1;
            }
        }
    }

    public void addMoney(int zl, int gr){
        addZl(zl);
        addGr(gr);
    }

    public boolean subMoney(double kosztBiletu){
        double roznica = this.stanPortfela() - kosztBiletu;
        System.out.println("Roznica " + roznica);
        if(roznica>0){
            this.clearPortfel();
            int zl = (int)roznica;
            System.out.println("ZL" + zl);
            double gr = Math.round(((roznica-zl)*100)*100.0)/100.0;
            System.out.println(roznica-zl);
            System.out.println("GR" + gr);
            this.addMoney(zl, (int)gr);
            return true;
        }
        return false;
    }

    public void checkMoney(){
        StringBuilder sb=new StringBuilder();
        for (ArrayList<Pieniadz> pieniadze : money) {
            if(!pieniadze.isEmpty()) {
                sb.append("[").append(pieniadze.get(0).toString()).append(" = ").append(pieniadze.size()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null,sb.toString(), "Portfel info", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override public String toString(){
        return ("[STAN PORTFELA = " + this.stanPortfela()+"zl]");
    }

}
