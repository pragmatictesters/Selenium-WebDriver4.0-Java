package com.pragmatic.java.primitives;

public class ConstantsExample {

    public static void main(String[] args) {
        Bicycle bicycle = new Bicycle();
        System.out.println("bicycle.getGear() = " + bicycle.getGear());
    }
}


class  Bicycle{

    private static  final int NUM_GEARS= 6;
    
    public int getGear(){
        return NUM_GEARS;
    }
}



