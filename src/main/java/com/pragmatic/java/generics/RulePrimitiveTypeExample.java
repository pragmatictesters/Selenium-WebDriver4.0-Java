package com.pragmatic.java.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Use corresponding object wrapper class to deal with primitive data types
 *
 * Reference : https://docs.oracle.com/javase/tutorial/java/data/autoboxing.html
 */

public class RulePrimitiveTypeExample {


    public static void main(String[] args) {
        //List<int> listOfIntegers = new ArrayList<>(); //Primitive data types are not allowed
        List<Integer> listOfIntegers = new ArrayList<>();
        listOfIntegers.add(10); //Auto boxing. Converting a primitive type (e.g. int)  to a corresponding  Object wrapper class (e.g. Integer)

        int firstNumber = listOfIntegers.get(0); //Auto unboxing
        System.out.println("firstNumber = " + firstNumber);
    }
}
