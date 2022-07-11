package com.pragmatic.java.strings;

public class StringDefaultValueExample {
    private static String name;
    public static void main(String[] args) {
        System.out.println(name);

        if (name==null){
            System.out.println("Name is not defined yet!");
        }
    }
}
