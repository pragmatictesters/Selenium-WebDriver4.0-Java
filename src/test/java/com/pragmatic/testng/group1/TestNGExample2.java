package com.pragmatic.testng.group1;

import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadTimeoutException;

public class TestNGExample2 {


    @Test(timeOut = 2000)
    public void testMethod1() throws InterruptedException {
        System.out.println("TestNGExample2.testMethod1");
        Thread.sleep(1200);
    }
     @Test(timeOut = 2000, expectedExceptions = {ThreadTimeoutException.class})
    public void testMethod2() throws InterruptedException {
        System.out.println("TestNGExample2.testMethod2");
        Thread.sleep(2100);
    }
     @Test(timeOut = 2000)
    public void testMethod3() throws InterruptedException {
        System.out.println("TestNGExample2.testMethod3");
         Thread.sleep(2100);
    }
     @Test
    public void testMethod4() {
        System.out.println("TestNGExample2.testMethod4");
    }


}
