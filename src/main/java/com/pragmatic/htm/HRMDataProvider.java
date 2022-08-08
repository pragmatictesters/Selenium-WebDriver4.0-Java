package com.pragmatic.htm;

import org.testng.annotations.DataProvider;

public class HRMDataProvider {

    @DataProvider(name = "loginUserInput")
    public static Object[][] loginUserInput(){

        return new Object[][]{
                {"", "","Username cannot be empty" },
                {"", "Ptl@#321","Username cannot be empty" },
                {"Admin", "","Password cannot be empty" },
                {"Admin", "InvalidPWD","Invalid credentials" }
        };
    }
}
