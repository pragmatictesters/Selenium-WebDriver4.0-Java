package com.pragmatic.java.strings;

public class StringConcatenationExample {

    public static void main(String[] args) {
        String firstName = "Janesh";
        String lastName = "Kodikara";
        String fullName = firstName + " " + lastName;
        System.out.println("fullName = " + fullName);

        fullName = String.format("%s %s", firstName, lastName);
        System.out.println("fullName = " + fullName);

        fullName = """
                %s %s
                """.formatted(firstName, lastName);
        System.out.println("fullName generated with a text block = " + fullName);

       int num1, num2, num3;
       num1=num2=num3=10;
       System.out.println("num1 + num2+num3 ==>> " + num1 + num2 + num3);
       System.out.println( num1 + num2 + num3 + " <== num1 + num2+num3 ");
       System.out.println( Integer.toString(num1) + Integer.toString(num2) + Integer.toString(num3) + " <== num1 + num2+num3 ");
       System.out.println( num1 + num2 + num3 );

        System.out.println(firstName.concat(" ").concat(lastName));


    }

}
