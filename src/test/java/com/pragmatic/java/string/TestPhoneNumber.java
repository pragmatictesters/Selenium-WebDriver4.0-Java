package com.pragmatic.java.string;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Solution for exercise 4
 * Generate a random phone number
 */
public class TestPhoneNumber {

    public static void main(String[] args) {

        String randomPhoneNumber = DataManager.getPhoneNumber("071", 10);
        assertThat(randomPhoneNumber).startsWith("071");
        assertThat(randomPhoneNumber.length()).isEqualTo(10);
        assertThat(randomPhoneNumber).matches("071\\d{7}");
        System.out.printf("Random phone number %s", randomPhoneNumber);
    }
}
