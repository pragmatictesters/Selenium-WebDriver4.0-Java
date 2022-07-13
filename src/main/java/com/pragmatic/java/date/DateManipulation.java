package com.pragmatic.java.date;

import java.time.LocalDate;

public class DateManipulation {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.now();

        System.out.println("date1.plusMonths(10) = " + date1.plusMonths(10));
        System.out.println("date1.plusDays(3) = " + date1.plusDays(3));
        System.out.println("date1.minusDays(7) = " + date1.minusYears(7));
        System.out.println("date1.minusWeeks() = " + date1.minusWeeks(1));
        
    }
}
