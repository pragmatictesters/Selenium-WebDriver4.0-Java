package com.pragmatic.java.generics;

import java.text.MessageFormat;

public class Fruit  implements  Boxable{
    private String name;
    private String country;
    private double weight;

    public Fruit(String name, String country, double weight) {
        this.name = name;
        this.country = country;
        this.weight = weight;
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

    @Override
    public double getWeight() {
        return weight;
    }
}
