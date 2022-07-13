package com.pragmatic.java.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class AdjustDatesExample {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.now();
        System.out.println("date1.with(TemporalAdjusters.lastDayOfYear()) = " + date1.with(TemporalAdjusters.lastDayOfYear()));
        System.out.println("date1.with(TemporalAdjusters.lastDayOfYear()) = " + date1.with(TemporalAdjusters.lastDayOfYear()));
        System.out.println("date1.with(TemporalAdjusters.firstDayOfMonth()) = " + date1.with(TemporalAdjusters.firstDayOfMonth()));


        System.out.println("Next Monday = " + date1.with(TemporalAdjusters.next(DayOfWeek.MONDAY)));
        System.out.println("Last Saturday = " + date1.with(TemporalAdjusters.previous(DayOfWeek.SATURDAY)));


    }
}
