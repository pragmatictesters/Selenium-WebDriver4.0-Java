package com.pragmatic.testng.group4;

import org.testng.annotations.Test;

public class TestNGExample2 {


    @Test(expectedExceptions = {IllegalArgumentException.class, ArrayIndexOutOfBoundsException.class})
    public void testMethod1() {
        String[] names = new String[3];
        System.out.println("TestNGExample2.testMethod1");
        System.out.println(names[3]);
    }
     @Test
    public void testMethod2() {
        System.out.println("TestNGExample2.testMethod2");
    }
     @Test
    public void testMethod3() {
        System.out.println("TestNGExample2.testMethod3");
    }
     @Test
    public void testMethod4() {
        System.out.println("TestNGExample2.testMethod4");
    }


}
