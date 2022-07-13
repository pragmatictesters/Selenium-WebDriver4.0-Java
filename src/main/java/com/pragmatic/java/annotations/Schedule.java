package com.pragmatic.java.annotations;

import java.lang.annotation.Repeatable;

@Repeatable(value = Schedules.class)
@interface Schedule {
    String dayOfMonth() default "first";
    String dayOfWeek() default "Mon";
    int hour() default 12;
}



