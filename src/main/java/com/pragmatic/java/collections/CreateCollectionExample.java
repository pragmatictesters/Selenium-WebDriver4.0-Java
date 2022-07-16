package com.pragmatic.java.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class CreateCollectionExample {

    public static void main(String[] args) {

        Collection<String> c = new ArrayList<>();
        c.add("Sri Lanka");
        c.add("America");
        c.add("Australia");
        c.add("Sri Lanka");
        System.out.println(c);

        Collection<String> uniqueCountries = new HashSet<>(c);
        System.out.println(uniqueCountries);


    }
}
