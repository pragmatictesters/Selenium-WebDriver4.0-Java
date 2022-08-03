package com.pragmatic.dates;

import java.time.LocalDate;

/**
 * A solution for Day2 question 2
 * Refer to
 * <a href="https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/LocalDate.html">LocalDate</a>
 */
public class DatesTester {


    public static void main(String[] args) {

        LocalDate today = DateManager.getCurrentDate();
        System.out.println(today); //toString() will be called automatically

        String formattedDate= DateManager.formatDate( today, "dd/MM/yyyy");
        System.out.printf("Formatted date %s\n", formattedDate);

        LocalDate futureDate = DateManager.addDays(today, 10);
        System.out.println("futureDate = " + futureDate);

        LocalDate nextMonday = DateManager.getNextMonday(today);
        System.out.println("nextMonday = " + nextMonday);

    }
}
