package com.pragmatic.java.generics;

import java.util.ArrayList;
import java.util.List;

public class WithoutGenericsExample {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(21); //Type safety is not checked at compile time
        //list.add("English");

        String english = new String("English");
        list.add(english);
        printLanguage(list);
    }

    private static void printLanguage(List list) {
        String firstLanguage = (String) list.get(0); //Explicit casting is required
        System.out.println("firstLanguage = " + firstLanguage);
    }
}
