package com.pragmatic.testng.group4;

import com.pragmatic.testng.RetryTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class TestNGExample1 {


    @Test (retryAnalyzer = RetryTest.class)
    public void testMethod1() {
        Random random= new Random();
        System.out.println("TestNGExample1.testMethod1");
        if(random.nextInt(5)>2) Assert.fail("Forceful failure");
    }
     @Test
    public void testMethod2() {
        System.out.println("TestNGExample1.testMethod2");
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
