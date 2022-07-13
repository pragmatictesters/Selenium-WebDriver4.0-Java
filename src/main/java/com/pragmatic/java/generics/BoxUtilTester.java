package com.pragmatic.java.generics;

public class BoxUtilTester {

    public static void main(String[] args) {
        Box<Fruit> fruitBox = new Box<>();
        fruitBox.addItem(new Fruit("Mango", "Sri Lanka", 10.5));
        fruitBox.addItem(new Fruit("Banana", "South Africa",5.5));
        fruitBox.addItem(new Fruit("Kivi", "New Zealand",7.2));
        
        System.out.println("utils.getItemCount(fruitBox) = " + BoxUtils.getItemCount(fruitBox));
       
    }
}
