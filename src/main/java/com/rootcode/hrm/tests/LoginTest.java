package com.rootcode.hrm.tests;

import com.rootcode.hrm.HRMBaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest  extends HRMBaseTest {


    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.get("http://hrm.pragmatictestlabs.com");

    }


    @AfterMethod
    public void afterMethod(){
        if(driver!=null){
            driver.quit();
        }
    }

    @Test
    public void testLoginWithValidCredentials(){

    }


    @Test(enabled = false)
    public void testLoginWithInvalidPassword() {
    }

    @Test(enabled = false)
    public void testLoginWithBlankUsernameAndBlankPassword() {

    }
}
