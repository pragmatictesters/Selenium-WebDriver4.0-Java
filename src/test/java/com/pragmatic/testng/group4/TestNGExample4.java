package com.pragmatic.testng.group4;

import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGExample4 extends TestNGTestBase {


    @Parameters("browser")
    @Test
    public void testMethod1(String browserName) {
        System.out.println("TestNGExample4.testMethod1");
        System.out.println("browserName = " + browserName);
    }
     @Test
    public void testMethod2() {
        System.out.println("TestNGExample4.testMethod2");
    }
     @Test
    public void testMethod3() {
        System.out.println("TestNGExample4.testMethod3");
    }
     @Test
    public void testMethod4() {
        System.out.println("TestNGExample4.testMethod4");
    }


}
