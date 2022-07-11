package com.pragmatic.java.strings;

public class StringComparisonExample {


    public static void main(String[] args) {
        String company1 = "Pragmatic";
        String company2 = new String ("Pragmatic");



        //SHOULD NOT BE USED. == is used for references not String values
        if (company1 == company2) {
            System.out.println("Two companies are equal");
        } else {
            System.out.println("Two companies are not equal ");
        }

        if (company1.equals(company2)) {
            System.out.println("Two companies are equal");
        } else {
            System.out.println("Two companies are not equal ");
        }


        company2 = "PRAGMATIC";
        if (company1.equalsIgnoreCase(company2)) {
            System.out.println("Two companies are equal");
        } else {
            System.out.println("Two companies are not equal ");
        }




    }
}
