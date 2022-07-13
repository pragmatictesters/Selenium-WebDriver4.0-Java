package com.pragmatic.java.generics;

import java.text.MessageFormat;

public class Fruit {
    private String name;
    private String country;

    public Fruit(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return MessageFormat.format("Fruit'{'name=''{0}'', country=''{1}'''}'", name, country);
    }
}
