package com.pragmatic.java.strings;

/**
 *
 * API Docs : https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html
 */
public class StringManipulationExample {


    public static void main(String[] args) {
        String companyName = "Pragmatic Test Labs";

        String[] words = companyName.split(" ");
        for (String word : words) {
            System.out.println("word = " + word);
        }

        System.out.println("Character count = " + companyName.length());
        System.out.println("TO UPPER CASE " + companyName.toUpperCase());
        System.out.println("First word " + companyName.substring(0, companyName.indexOf(" ")));
        System.out.println("New company name " + companyName.replace("Test Labs","Testers"));

    }
}
