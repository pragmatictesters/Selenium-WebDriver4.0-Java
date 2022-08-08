package com.pragmatic.hrm;

import com.pragmatic.hrm.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

public class BaseTest {


    @BeforeSuite
    public void beforeSuite(){
        WebDriverManager.chromedriver().setup();
        BrowserManager browserManager = new BrowserManager();
        browserManager.setupDriver("chrome");


    }

    protected void login(WebDriver driver) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUsername("Admin")
                .typePassword("Ptl@#321")
                .clickLogin();
    }
}
