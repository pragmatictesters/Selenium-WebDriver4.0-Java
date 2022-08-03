package com.pragmatic.dates;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class DateManager {
    public static LocalDate getCurrentDate() {
        LocalDate today = LocalDate.now();
        return today;
    }

    public static String formatDate(LocalDate dateToFormat, String pattern) {
        return dateToFormat.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDate addDays(LocalDate baseDate, int daysToAdd) {
        return baseDate.plusDays(daysToAdd);
    }


    public static LocalDate getNextMonday(LocalDate baseDate) {
            return baseDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
    }
}
