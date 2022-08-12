package com.pragmatic.testng.group2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGExample6 {


    @Test(dependsOnMethods = {"testMethod2","testMethod4"})
    public void testMethod1() {
        System.out.println("TestNGExample6.testMethod1");
    }
     @Test
    public void testMethod2() {
        System.out.println("TestNGExample6.testMethod2");
    }
     @Test
    public void testMethod3() {
        System.out.println("TestNGExample6.testMethod3");
    }
     @Test
    public void testMethod4() {
        System.out.println("TestNGExample6.testMethod4");
         Assert.fail("Forceful failure ");
    }


}
