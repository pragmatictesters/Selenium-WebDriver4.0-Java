package com.pragmatic.testng.group1;

import org.testng.annotations.Test;

import java.util.Random;

public class TestNGExample8 {


    @Test(singleThreaded = false, threadPoolSize = 5, invocationCount = 20)
    public void testMethod1() throws InterruptedException {
        System.out.println("TestNGExample1.testMethod1");
        Thread.sleep(2000);
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
         Random random= new Random();
         random.ints(10).forEach(num -> System.out.println(num));
        System.out.println("TestNGExample1.testMethod4");
    }


}
