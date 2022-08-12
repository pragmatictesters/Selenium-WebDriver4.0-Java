package com.pragmatic.testng.group2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGExample9 {



    @Test(dependsOnGroups = {"init"}, alwaysRun = true)
    public void testMethod1() {
        System.out.println("TestNGExample8.testMethod1");
    }
    @Test(groups = {"init"})
    public void testMethod2() {
        System.out.println("TestNGExample8.testMethod2");
    }
    @Test
    public void testMethod3() {
        System.out.println("TestNGExample8.testMethod3");
    }
    @Test(groups = {"init"})
    public void testMethod4() {
        System.out.println("TestNGExample8.testMethod4");
        Assert.fail("Forceful failure");
    }


}
