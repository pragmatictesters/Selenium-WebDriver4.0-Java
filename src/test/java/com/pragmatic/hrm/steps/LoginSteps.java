package com.pragmatic.hrm.steps;

import com.pragmatic.hrm.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;


public class LoginSteps {

    LoginPage loginPage;
    private WebDriver driver;


    @Before
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    @After
    public void after(){
        if (driver!=null){
            driver.quit();
        }
    }

    @Given("User has accessed the login page")
    public void userHasAccessedTheLoginPage() {
        driver.get("http://hrm.pragmatictestlabs.com");
        loginPage = new LoginPage(driver);
    }

    @When("Uer type username {string}")
    public void uerTypeUsername(String userName) {
        loginPage.typeUsername(userName);
    }

    @And("Type password {string}")
    public void typePassword(String password) {
        loginPage.typePassword(password);
    }

    @And("Click login button")
    public void clickLoginButton() {
        loginPage.clickLogin();
    }

    @Then("Use should get an error message {string}")
    public void useShouldGetAnErrorMessage(String expectedError) {
        assertThat(loginPage.getError()).isEqualTo(expectedError);
    }

    @Then("Use should see welcome message {string}")
    public void useShouldSeeWelcomeMessage(String welcomeMessage) {

    }
}
