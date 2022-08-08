package com.rootcode.hrm;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeSuite;

public class HRMBaseTest {



    @BeforeSuite
    public void beforeSuite(){
        //TODO: We will introduce a Browser Manager here
        WebDriverManager.chromedriver().setup();
        System.out.println("HRMBaseTest.beforeSuite");
    }

}
