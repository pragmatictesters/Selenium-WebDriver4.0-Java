package com.pragmatic.java.primitives;


/**
 * This example contains declaring, initialisation of variables with primitive data types
 * The scope is limited to the mostly used data types in Selenium test automation
 *
 * Reference extracts from  official site
 * The Java programming language is statically-typed,
 * which means that all variables must first be declared before they can be used.
 * This involves stating the variable's type and name, as you've already seen:
 *
 * For detailed documentation : https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
 *
 * Naming convention
 * lowerCamel case should be used for variable names
 *
 * Primitive data types supported by Java
 * short, byte, int, long, double, float, char, boolean
 *
 * NOTE :
 * 1.Sting is NOT a primitive data type. It's an Object
 * 2.Default values are not assigned to local variables
 *
 *
 */
public class LocalVariablesExample {



    public static void main(String[] args) {

        //Data type int to store positive and negative numbers
        int productCount ; //Declaration
        //System.out.println("productCount = " + productCount); //You cannot use variables without initializations
        productCount = 10; //Initialization
        System.out.println("productCount = " + productCount);

        int negativeInteger = -100; //Declaration and initialization at the same time
        System.out.println("negativeInteger = " + negativeInteger);

        //Data type for storing numbers with decimal values
        float productPrice = 10.3f;
        System.out.println("productPrice = " + productPrice);


        //To store true/false for conditions
        boolean isAvailable = true;
        System.out.println("isAvailable = " + isAvailable);

        //To store a single character
        char nicSuffix = 'V';//Characters should be enclosed with single quotes '
        System.out.println("nicSuffix = " + nicSuffix);



    }

}
