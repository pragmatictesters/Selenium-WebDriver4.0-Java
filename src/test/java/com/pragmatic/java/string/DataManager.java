package com.pragmatic.java.string;

import com.github.javafaker.Faker;

public class DataManager {
    public static String getPhoneNumber() {
        return  getPhoneNumber("071",10);
    }

    public static String getPhoneNumber(String prefix, int length) {

        if(prefix.isBlank()) throw  new IllegalArgumentException("Prefix cannot be blank");
        if(prefix.length()>4 || prefix.length()<2) throw  new IllegalArgumentException("Prefix should be within 2-4 digits");

        Faker faker = new Faker();
        int lengthSuffix = length - prefix.length();
        String suffix = faker.number().digits(lengthSuffix);
        return String.format("%s%s", prefix, suffix);
    }
}
