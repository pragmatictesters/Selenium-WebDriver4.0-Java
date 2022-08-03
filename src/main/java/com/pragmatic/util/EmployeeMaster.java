package com.pragmatic.util;

import com.github.javafaker.Faker;

import java.util.Random;

public class EmployeeMaster {


    public static Employee getEmployee() {

        String firstName = getFirstName();
        String lastName = getFirstName();
        var empNumber = getEmployeeNumber();
        Employee employee = new Employee(firstName, lastName, empNumber);
        return employee;
    }

    private static String getEmployeeNumber() {
        return getEmployeeNumber("RC-QA");
    }

    private static String getEmployeeNumber(String prefix) {
        Faker faker = new Faker();
        var suffix = faker.number().digits(5).toString();
        return String.format("%s-%s", prefix, suffix) ;
    }

    private static String getFirstName() {
        var faker = new Faker();
        return faker.name().firstName().replaceAll("'", "");
    }

    private static String getLastName() {
        var faker = new Faker();
        return faker.name().lastName().replaceAll("'", "");
    }


}
