package com.rootcode.sauce;

import org.testng.annotations.DataProvider;

public class SauceDataProvider {
    @DataProvider(name = "invalid-login-inputs")
    public static Object[][] invalidLoginInputs(){
        return new  Object[][] {
                {"","","Username is required"},
                {"standard_user","","Password is required"},
                {"standard_user","asssee","Username and password do not match any user in this service"}
        };
    }


    @DataProvider(name = "product-names")
    public static Object[][] productNames(){
        return new Object[][] {
                {"Sauce Labs Backpack"},
                {"Sauce Labs Bike Light"},
                {"Sauce Labs Bolt T-Shirt"},
                {"Sauce Labs Fleece Jacket"},
                {"Sauce Labs Onesie"},
                {"Test.allTheThings() T-Shirt (Red)"}
        };
    }
}
