package com.pragmatic.java.annotations;


import java.lang.annotation.Documented;

@Authors(author = "Janesh",
        date = "13/07/2022",
        reviewers = {"Janesh", "Chandika"},
        currentRevision = 2,
        lastModified = "13/07/2022",
        lastModifiedBy = "Janesh"
)
public class BasicAnnotationExample {


    @SuppressWarnings("checked")
    public void suppressWarningWithoutElement(){
        System.out.println("Suppress Warning !");
    }


    @SuppressWarnings(value = "checked")
    public void suppressWarningWithElement(){
        System.out.println("Suppress Warning !");
    }

    @Override
    public String toString(){
        return  super.toString();
    }



}
