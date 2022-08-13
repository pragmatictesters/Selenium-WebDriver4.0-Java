package com.pragmatic.testng.group5;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestNGExample1 {


    @Test(dataProvider = "login-data")
    public void testMethod1(String userName, String password, String expectedOutcome) {
        System.out.println("TestNGExample1.testMethod1");
        System.out.println("userName = " + userName + ", password = " + password + ", expectedOutcome = " + expectedOutcome);
    }
    @Test(dataProvider = "login-data-csv")
    public void testMethod2(String[] loginData) {
        System.out.println("TestNGExample1.testMethod2");
        System.out.println("userName = " +  loginData[0] + " password " +loginData[1]  + " expectedOutcome " + loginData[2]);
    }
     @Test
    public void testMethod3() {
        System.out.println("TestNGExample1.testMethod3");
    }
     @Test
    public void testMethod4() {
        System.out.println("TestNGExample1.testMethod4");
    }

    @DataProvider(name = "login-data")
    public Object[][] loginData(){
        return new Object[][] {
                {"", "", "Username cannot be empty"},
                {"", "Ptl@#321", "Username cannot be empty"},
                {"Admin", "", "Password cannot be empty"},
        };
    }


    @DataProvider(name = "login-data-csv")
    public Object[][] loginDataCSV(){
        Object[][] objects;
        try {
            CSVReader csvReader = new CSVReader(new FileReader(String.format("%s/testData/login-data.csv", System.getProperty("user.dir"))));
            List<String[]> allRecords = csvReader.readAll();
            int recordCount =  allRecords.size();
            System.out.println("recordCount = " + recordCount);
            objects = new Object[recordCount][1];
            int currentRow = 0;
            for (String[] record: allRecords) {
                objects[currentRow++][0]= record;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }


        return objects;
    }



}
