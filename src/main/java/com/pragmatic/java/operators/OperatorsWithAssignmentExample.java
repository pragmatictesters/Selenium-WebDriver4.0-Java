package com.pragmatic.java.operators;

public class OperatorsWithAssignmentExample {

    public static void main(String[] args) {
        int headCount = 100;
        System.out.println("Initial headCount = " + headCount);

        headCount += 10;

        System.out.println("headCount after increment  = " + headCount);

        headCount -= 5;
        System.out.println("headCount after decrement = " + headCount);


        boolean success = false;
        // false
        System.out.println(success);
        // true
        System.out.println(!success);



    }
}
