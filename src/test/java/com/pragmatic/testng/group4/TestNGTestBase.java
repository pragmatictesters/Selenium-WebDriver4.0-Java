package com.pragmatic.testng.group4;

import org.testng.annotations.*;

public class TestNGTestBase {


    @BeforeSuite
    public void beforeSuite(){
        System.out.println("TestNGTestBase.beforeSuite");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("TestNGTestBase.afterSuite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("TestNGTestBase.beforeTest");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("TestNGTestBase.afterTest");
    }

    @BeforeGroups(groups = {"smoke"})
    public void beforeSmokeGroups(){
        System.out.println("TestNGTestBase.beforeSmokeGroups");
    }

    @AfterGroups(groups = {"smoke"})
    public void afterSmokeGroups(){
        System.out.println("TestNGTestBase.afterSmokeGroups");
    }

    @BeforeGroups(groups = {"regression"})
    public void beforeRegressionGroups(){
        System.out.println("TestNGTestBase.beforeRegressionGroups");
    }


    @BeforeClass
    public void beforeClass(){
        System.out.println("TestNGTestBase.beforeClass");
    }


    @AfterClass
    public void afterClass(){
        System.out.println("TestNGTestBase.afterClass");
    }


    @BeforeMethod
    public void beforeMethod(){
        System.out.println("TestNGTestBase.beforeMethod");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("TestNGTestBase.afterMethod");
    }


}
