package com.pragmatic.java.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class CurrentDateExample {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today.toString());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String formattedDate = today.format(formatter);
        System.out.println("formattedDate = " + formattedDate);

    }
}
