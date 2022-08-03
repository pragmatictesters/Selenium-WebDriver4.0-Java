package com.pragmatic.util;

public record Employee(String firstName, String lastName, String empNumber) {

    public String getFullName(){
        return String.format("%s %s", firstName(), lastName());
    }
}
