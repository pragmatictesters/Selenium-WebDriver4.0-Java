package com.pragmatic.java.annotations;

public class RepeatableAnnotationExample {

    @Schedule()
    @Schedule(dayOfMonth = "second",dayOfWeek = "Tue", hour = 3)
    public void repeatableAnnotationExample(){
        System.out.println("I am in repeatably annotated example");
    }

}
