package com.rootcode.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestSauceDemoLogin {
    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
        //WebDriverManager.safaridriver().setup();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        //driver = new SafariDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().minimize();
    }


    @AfterMethod
    public void afterMethod() {
        if (driver != null) {
            driver.close();
        }
    }

    @Test(priority = 2)
    public void testLoginWithValidCredentials() {
        ///User actions
        //Type username
        String username = "standard_user";
        String password = "secret_sauce";



        driver.findElement(By.id("user-name")).sendKeys(username);
        String attributeValue = driver.findElement(By.id("user-name")).getAttribute("value");
        assertThat(attributeValue).isEqualTo(username);

        //Type password
        driver.findElement(By.id("password")).sendKeys(password);

        //Click login button
        driver.findElement(By.id("login-button")).click();

        String actualTitle = driver.findElement(By.className("title")).getText();
        //Verify the outcome against the expected
        assertThat(actualTitle.toLowerCase()).isEqualTo("products");
    }

    @Test
    public void testLoginWithValidCredentialsWithPressEnterKey() {
        ///User actions
        //Type username
        String username = "standard_user";
        String password = "secret_sauce";

        driver.findElement(By.id("user-name")).sendKeys(username);
        String attributeValue = driver.findElement(By.id("user-name")).getAttribute("value");
        assertThat(attributeValue).isEqualTo(username);

        //Type password and press enter key
        driver.findElement(By.id("password")).sendKeys(password + Keys.ENTER);


        String actualTitle = driver.findElement(By.className("title")).getText();
        //Verify the outcome against the expected
        assertThat(actualTitle).isEqualTo("PRODUCTS");
    }


    @Test
    public void testLoginWithValidCredentialsWithSubmit() {
        ///User actions
        //Type username
        String username = "standard_user";
        String password = "secret_sauce";

        driver.findElement(By.id("user-name")).sendKeys(username);
        String attributeValue = driver.findElement(By.id("user-name")).getAttribute("value");
        assertThat(attributeValue).isEqualTo(username);

        //Type password and press enter key
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("password")).submit();

        String actualTitle = driver.findElement(By.className("title")).getText();
        //Verify the outcome against the expected
        assertThat(actualTitle).isEqualTo("PRODUCTS");
    }




    @Test(priority = 1)
    public void testLoginWithInvalidPassword() {
        String expectedError = "Epic sadface: Username and password do not match any user in this service";

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Type password
        driver.findElement(By.id("password")).sendKeys("invalid_sauce");

        //Click login button
        driver.findElement(By.id("login-button")).click();

        String actualError = driver.findElement(By.tagName("h3")).getText();
        assertThat(actualError).containsIgnoringCase(expectedError);
    }


    @Test(enabled = false)
    public void testLoginWithBlankPassword() {
        System.out.println("TestSauceDemoLogin.testLoginWithBlankPassword");
    }

    @Test(enabled = false)
    public void testLoginWithInvalidUsername() {
        System.out.println("TestSauceDemoLogin.testLoginWithInvalidUsername");
    }


    @Test(enabled = false)
    public void testBlankUsernameAndBlankPassword() {
        System.out.println("TestSauceDemoLogin.testBlankUsernameAndBlankPassword");
    }
}
