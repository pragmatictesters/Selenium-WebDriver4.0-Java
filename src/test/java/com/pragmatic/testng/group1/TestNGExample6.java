package com.pragmatic.testng.group1;

import org.testng.annotations.Test;

public class TestNGExample6 {


    @Test(invocationCount = 3)
    public void testMethod1() {
        System.out.println("TestNGExample1.testMethod1");
    }
     @Test(invocationCount = 5, invocationTimeOut = 5000)
    public void testMethod2() throws InterruptedException {
        System.out.println("TestNGExample1.testMethod2");
        Thread.sleep(1050);
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
