package com.pragmatic.assertj;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SoftAssertionExample {

    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

    @Test
    public void testSoftAssertions() {
        SoftAssertions softAssertions = new SoftAssertions();

        driver.navigate().to("https://www.saucedemo.com");
        softAssertions.assertThat(driver.getTitle())
                .as("Title verification failed")
                .containsIgnoringCase("Swag Labs")
                .startsWith("SwagK")
                .endsWith("Labs")
                .endsWithIgnoringCase("labsK");


        softAssertions.assertAll();

    }
}
