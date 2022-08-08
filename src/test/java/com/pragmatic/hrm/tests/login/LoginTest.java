package com.pragmatic.hrm.tests.login;

import com.pragmatic.hrm.BaseTest;
import com.pragmatic.hrm.BrowserManager;
import com.pragmatic.hrm.HRMDataProvider;
import com.pragmatic.hrm.pages.LandingPage;
import com.pragmatic.hrm.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseTest {


    private WebDriver driver;
    private BrowserManager browserManager;

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("I am from before method  inside BASE!");
        browserManager = new BrowserManager();
        driver = browserManager.launchBrowser("chrome");
        driver.get("http://hrm.pragmatictestlabs.com");
    }


    @AfterMethod
    public void afterMethod() {
        browserManager.closeBrowserWindows();
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
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.typeUsername(userName).typePassword(password).clickLogin();
        String errorMessage = loginPage.getError();
        assertThat(errorMessage).isEqualTo(expectedOutcome);
    }




}
