package com.pragmatic.java.string;

import com.github.javafaker.Faker;
import static org.assertj.core.api.Assertions.assertThat;


/**
 * Solution for exercise 2
 * Create four variables to hold address information and create a method to get Address.
 *
 */
public class AddressTest {


    public static void main(String[] args) {
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

        assertThat(address.addressLine1()).isEqualTo(addressLine1);
        assertThat(address.addressLine2()).isEqualTo(addressLine2);
        assertThat(address.city()).isEqualTo(city);
        assertThat(address.postCode()).isEqualTo(postCode);
        assertThat(address.getAddress()).isEqualTo(addressLine1 + ",\n"
                + addressLine2 + ",\n"
                + city + ",\n"
                + postCode+ ".");

        System.out.println(address.getAddress());

    }
}
