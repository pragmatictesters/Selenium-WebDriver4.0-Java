package com.pragmatic.testng.group1;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class TestNGExample7 {


    @Test(successPercentage = 100, invocationTimeOut = 10)
    public void testMethod1() {
        System.out.println("Running the test");
        Random random=new Random();
        if (random.nextInt(5)>1) Assert.fail("Forced failure");
        System.out.println("TestNGExample1.testMethod1");

    }
     @Test(successPercentage = 50)
    public void testMethod2() {
        System.out.println("TestNGExample1.testMethod2");
         SoftAssert softAssert = new SoftAssert();
         softAssert.assertTrue(true);
         softAssert.assertTrue(true);
         softAssert.assertTrue(true);
         softAssert.assertTrue(true);
         softAssert.assertAll();
    }
     @Test
    public void testMethod3() {
        System.out.println("TestNGExample1.testMethod3");
    }
     @Test
    public void testMethod4() {
        System.out.println("TestNGExample1.testMethod4");
    }


}
