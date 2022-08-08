package com.rootcode.hrm.tests;

import com.rootcode.hrm.HRMBaseTest;
import com.rootcode.hrm.pages.LandingPage;
import com.rootcode.hrm.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.*;


public class LoginTest  extends HRMBaseTest {


    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.get("http://hrm.pragmatictestlabs.com");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //DO NOT USE THIS TOO

    }


    @AfterMethod
    public void afterMethod(){
        if(driver!=null){
            driver.quit();
        }
    }

    @Test
    public void testLoginWithValidCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUsername("Admin")
                .typePassword("Ptl@#321")
                .clickLogin();
        LandingPage landingPage = new LandingPage(driver);

        assertThat(landingPage.getWelcomeMessage()).isEqualTo("Welcome Admin");

    }

     @Test
    public void testLoginWithValidCredentialsAndLogout() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUsername("Admin")
                .typePassword("Ptl@#321")
                .clickLogin();
        LandingPage landingPage = new LandingPage(driver);
        landingPage.logout();
    }





    @Test()
    public void testLoginWithInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUsername("Admin")
                .typePassword("InvalidPWD")
                .clickLogin();

        assertThat(loginPage.getError()).isEqualTo("Invalid credentials");

    }

    @Test()
    public void testLoginWithBlankUsernameAndBlankPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clearUsername()
                .clearPassword()
                .clickLogin();
        assertThat(loginPage.getError()).isEqualTo("Username cannot be empty");

    }
}
