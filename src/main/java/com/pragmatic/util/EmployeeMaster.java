package com.pragmatic.util;

import com.github.javafaker.Faker;

public class EmployeeMaster {


    public static Employee getEmployee() {

        String firstName = getFirstName();
        String lastName = getLastName();
        var empNumber = getEmployeeNumber();
        return new Employee(firstName, lastName, empNumber);
    }

    public static String getEmployeeNumber() {
        return getEmployeeNumber("RC-QA");
    }

    public static String getEmployeeNumber(String prefix) {
        Faker faker = new Faker();
        var suffix = faker.number().digits(5);
        return String.format("%s-%s", prefix, suffix) ;
    }

    public static String getFirstName() {
        var faker = new Faker();
        return faker.name().firstName().replaceAll("'", "");
    }

    public static String getLastName() {
        var faker = new Faker();
        return faker.name().lastName().replaceAll("'", "");
    }


}
