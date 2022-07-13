package com.pragmatic.java.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericExample {

    public static void main(String[] args) {
        List<String> languages = new ArrayList<String>();
        //languages.add(21); //Type safety is  checked at compile time
        languages.add("Sinhala");
        String english = new String("English");
        languages.add(english);
        printLanguage(languages);
    }

    private static void printLanguage(List<String> list) {
        String firstLanguage =  list.get(0); //Casting is NOT Required
        System.out.println("firstLanguage = " + firstLanguage);
    }
}
