package com.pragmatic.assertj;

import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.*;

public class DatesAssertionExample {

    @Test
    public void testComponentsOfDate(){
        LocalDate dateToTest = LocalDate.of(2022, Month.AUGUST, 6);
        assertThat(dateToTest)
                .hasYear(2022)
                .hasMonth(Month.AUGUST)
                .hasDayOfMonth(6);
    }

    @Test
    public void testWithAnOtherDate(){
        LocalDate dateToTest = LocalDate.of(2022, Month.AUGUST, 6);
        assertThat(dateToTest)
                .isBefore("2022-08-09")
                .isAfter("2022-07-02")
                .isBetween("2022-08-05", "2022-08-08")
                .isAfterOrEqualTo("2022-08-06");
    }

}
