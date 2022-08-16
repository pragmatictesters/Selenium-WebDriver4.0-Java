package com.pragmatic.testng.group4;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Test
public class TestNGExample5 {

    @Parameters("browser")
    public void testMethod1(String browserName) {
        System.out.println("TestNGExample5.testMethod1");
        System.out.println("browserName = " + browserName);
    }


    @Parameters("count")
    public void testMethod2(@Optional("20") int count) {
        System.out.println("TestNGExample5.testMethod2");
        System.out.println("count = " + count);
    }

    public void testMethod3() {
        System.out.println("TestNGExample5.testMethod3");
        Assert.fail("Forceful failure");
    }

    public void testMethod4() {
        System.out.println("TestNGExample5.testMethod4");
        Assert.fail("Forceful failure");
    }



}
