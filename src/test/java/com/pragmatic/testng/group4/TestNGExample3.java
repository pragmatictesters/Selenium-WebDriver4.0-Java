package com.pragmatic.testng.group4;

import org.testng.annotations.Test;

public class TestNGExample3  extends TestNGTestBase{


    @Test (invocationCount = 3)
    public void testMethod1() {
        System.out.println("TestNGExample3.testMethod1");
    }
     @Test
    public void testMethod2() {
        System.out.println("TestNGExample3.testMethod2");
    }
     @Test
    public void testMethod3() {
        System.out.println("TestNGExample3.testMethod3");
    }
     @Test
    public void testMethod4() {
        System.out.println("TestNGExample3.testMethod4");
    }


}
