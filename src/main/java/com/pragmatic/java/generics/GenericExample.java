package com.pragmatic.java.generics;

import java.util.ArrayList;
import java.util.List;

public class NonGenericExample {

    public static void main(String[] args) {
        List languages = new ArrayList();
        languages.add(21); //Type safety is not checked at compile time
        //languages.add("English");

        String english = new String("English");
        languages.add(english);
        printLanguage(languages);
    }

    private static void printLanguage(List list) {
        String firstLanguage = (String) list.get(0); //Explicit casting is required
        System.out.println("firstLanguage = " + firstLanguage);
    }
}
