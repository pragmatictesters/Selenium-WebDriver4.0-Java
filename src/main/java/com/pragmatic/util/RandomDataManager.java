package com.pragmatic.util;

import com.github.javafaker.Faker;

public class RandomDataManager {


    public static String getFirstName() {
        Faker faker = new Faker();
        return faker.name().firstName().replaceAll("'", "").strip();
    }

    public static String getLastName() {
        Faker faker = new Faker();
        return faker.name().lastName().replaceAll("'", "").strip();
    }





}
