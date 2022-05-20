package com.lab2a;

/**
 * Klasa implementuje stos w postaci tablicy elementow typu String
 * @author Lukasz Kaczynski
 * @version 1.1 Semestr III - Algorytmy i Struktury Danych [lab5 - Stos i kolejka fifo]
 */
public class Stack {
    private final int CAPACITY = 20;
    private final String[] elements;
    private int top;

    /**
     * Tworzy tablice String o wielkosci CAPACITY
     */
    public Stack(){
        elements = new String[CAPACITY];
        top = -1;
    }

    /**
     *
     * @return zwraca true, jesli stos jest pusty
     */
    public boolean empty() {
        return (top<0);
    }

    /**
     *
     * @return zwraca true, jesli stos jest pelny
     */
    public boolean full() {
        return (top==CAPACITY-1);
    }

    /**
     *
     * @param s element String, ktory chcemy dodac
     * @return dodaje element s na szczyt stosu i zwraca true w przypadku powodzenia
     */
    public boolean push(String s){
        if (full()) return false;
        top++;
        elements[top] = s;
        return true;
    }

    /**
     *
     * @return zwraca element ze szczytu stosu
     */
    public String peek(){
        if(empty()) throw new ArrayIndexOutOfBoundsException("Stos pusty");
        return elements[top];
    }

    /**
     *
     * @return usuwa element ze szczytu stosu i zwraca true w przypadku powodzenia
     */
    public boolean pop(){
        if (empty()) return false;
        top--;
        return true;
    }

    /**
     * Przywraca wartosci poczatkowe stosu
     */
    public void clear() {
        top = -1;
    }
}

