package com.pragmatic.java.string;

import com.beust.ah.A;
import com.github.javafaker.Faker;

public class Postmaster {
    public static Address getAddress() {
        Faker faker = new Faker();
        String addressLine1 = faker.address().streetAddressNumber();
        String addressLine2 = faker.address().streetName();
        String city = faker.address().city();
        String postCode = faker.address().zipCode();

        //We use Records in Java for our solution
        Address address = new Address(
                addressLine1,
                addressLine2,
                city,
                postCode
        );

        return  address;
    }
}
