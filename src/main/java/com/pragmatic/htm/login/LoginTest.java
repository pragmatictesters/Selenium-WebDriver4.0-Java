package com.pragmatic.htm.login;

import com.pragmatic.htm.BaseTest;
import com.pragmatic.htm.HRMDataProvider;
import com.pragmatic.htm.pages.LandingPage;
import com.pragmatic.htm.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseTest {


    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("I am from before method  inside BASE!");
        //driver = new ChromeDriver();
       // driver.get("http://hrm.pragmatictestlabs.com");
    }


    @AfterMethod
    public void afterMethod() {
        if (driver != null) {
            driver.close();
        }
    }

    @Test
    public void testValidUserLogin() {
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.typeUsername("Admin").typePassword("Ptl@#321").clickLogin();

        LandingPage landingPage = new LandingPage(this.driver);
        String welcomeMessage = landingPage.getWelcomeMessage();
        assertThat(welcomeMessage).isEqualTo("Welcome Admin");
    }

    @Test
    public void testValidUserLoginLogout() {
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.typeUsername("Admin").typePassword("Ptl@#321").clickLogin();

        LandingPage landingPage = new LandingPage(this.driver);
        landingPage.logout();
    }


    @Test
    public void testLoginWithBlankUsername() {
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.typeUsername("").typePassword("Ptl@#321").clickLogin();
        String errorMessage = loginPage.getError();
        assertThat(errorMessage).isEqualTo("Username cannot be empty");
    }

    @Test
    public void testLoginWithBlankUsernameAndBlankPassword() {
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.typeUsername("").typePassword("").clickLogin();
        String errorMessage = loginPage.getError();
        assertThat(errorMessage).isEqualTo("Username cannot be empty");
    }

    @Test
    public void testLoginWithBlankPassword() {
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.typeUsername("Admin").typePassword("").clickLogin();
        String errorMessage = loginPage.getError();
        assertThat(errorMessage).isEqualTo("Password cannot be empty");
    }

    @Test
    public void testLoginWithInvalidPassword() {
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.typeUsername("Admin").typePassword("InvalidPWD").clickLogin();
        String errorMessage = loginPage.getError();
        assertThat(errorMessage).isEqualTo("Invalid credentials");
    }


    @Test(dataProvider = "loginUserInput", dataProviderClass = HRMDataProvider.class)
    public void testDataDrivenTesting(String userName, String password, String expectedOutcome){
        System.out.println("userName = " + userName + ", password = " + password + ", expectedOutcome = " + expectedOutcome);
//        LoginPage loginPage = new LoginPage(this.driver);
//        loginPage.typeUsername(userName).typePassword(password).clickLogin();
//        String errorMessage = loginPage.getError();
//        assertThat(errorMessage).isEqualTo(expectedOutcome);
    }




}
