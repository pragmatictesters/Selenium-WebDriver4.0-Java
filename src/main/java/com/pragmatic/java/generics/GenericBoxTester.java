package com.pragmatic.java.generics;

public class GenericBoxTester {

    public static void main(String[] args) {
        Box<Fruit> fruitBox = new Box<>();
        fruitBox.addItem(new Fruit("Mango", "Sri Lanka"));
        fruitBox.addItem(new Fruit("Banana", "South Africa"));
        fruitBox.addItem(new Fruit("Kivi", "New Zealand"));

        System.out.println("fruitBox.getLatestItem() = " + fruitBox.getLatestItem());
        System.out.println("fruitBox = " + fruitBox);
    }
}
