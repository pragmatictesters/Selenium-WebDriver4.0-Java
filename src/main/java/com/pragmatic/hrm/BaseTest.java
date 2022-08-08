package com.pragmatic.hrm;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeSuite;

public class BaseTest {


    @BeforeSuite
    public void beforeSuite(){
        WebDriverManager.chromedriver().setup();
        BrowserManager browserManager = new BrowserManager();
        browserManager.setupDriver("chrome");


    }


}
