package com.pragmatic.java.string;

import org.apache.commons.lang3.math.NumberUtils;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This example demonstrate a solution for the exercise 2
 * Create two strings with price tags 10.5 and 12.5. Assign the total to a variable and display the total as "Total is USD 23.0"
 */
public class ConvertStringExample {


    public static void main(String[] args) {
        String price1 = "10.5";
        String price2 = "12.5";
        double total = getTotal(price1, price2);
        assertThat(total).isEqualTo(23.0D);
        printTotal(total);

    }

    /**
     * Print total value in USD
     * @param total value to be printed
     */
    private static void printTotal(double total) {
        System.out.printf("Total is USD %s", total);
    }

    /**
     * Add two strings and get total in double
     * @param value1 to be added
     * @param value2 to be added
     * @return total
     */
    private static double getTotal(String value1, String value2) {
        //Validate the numbers
        if (value1.isBlank() || value2.isBlank()) throw new IllegalArgumentException("Values cannot be blank");
        if (!NumberUtils.isCreatable(value1)) throw new IllegalArgumentException(String.format("Value %s is not a number", value1));
        if (!NumberUtils.isCreatable(value2)) throw new IllegalArgumentException(String.format("Value %s is not a number", value2));

        return Double.parseDouble(value1) + Double.parseDouble(value2);
    }


}
