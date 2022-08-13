package com.pragmatic.testng.group2;

import com.pragmatic.testng.group4.TestNGTestBase;
import org.testng.annotations.Test;

public class TestNGExample10  extends TestNGTestBase {


    @Test(groups = {"smoke"})
    public void testMethod1() {
        System.out.println("TestNGExample10.testMethod1");
    }
     @Test(groups = { "regression"})
    public void testMethod2() {
        System.out.println("TestNGExample10.testMethod2");
    }
     @Test(groups = { "regression"})
    public void testMethod3() {
        System.out.println("TestNGExample10.testMethod3");
    }
     @Test(groups = { "smoke"})
    public void testMethod4() {
        System.out.println("TestNGExample10.testMethod4");
    }

}
