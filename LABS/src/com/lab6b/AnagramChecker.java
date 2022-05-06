package com.lab6b;

import java.util.Arrays;

public class AnagramChecker implements IAnagramChecker{

    @Override
    public boolean isAnagram(String word1, String word2) {
        if(     word1.isEmpty() ||
                word2.isEmpty())    return false;
        if(word1.equalsIgnoreCase(word2)) return true;
        word1 = word1.replace(" ", "");
        word2 = word2.replace(" ", "");
        word1 = word1.toUpperCase();
        word2 = word2.toUpperCase();
        char[] wordOne = word1.toCharArray();
        Arrays.sort(wordOne);
        char[] wordTwo = word2.toCharArray();
        Arrays.sort(wordTwo);
        return Arrays.equals(wordOne, wordTwo);
    }
}

class Test{
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
