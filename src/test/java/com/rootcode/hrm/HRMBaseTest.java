package com.rootcode.hrm;

import com.rootcode.hrm.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

public class HRMBaseTest {


    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        //TODO: We will introduce a Browser Manager here
        WebDriverManager.chromedriver().setup();
        System.out.println("HRMBaseTest.beforeSuite");
    }

    protected void login(WebDriver driver) {
        this.driver = driver;
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUsername("Admin")
                .typePassword("Ptl@#321")
                .clickLogin();
    }
}
