package com.pragmatic.selenium.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.*;



public class CrossBrowserTesting {


    public static final String BASE_URL = "http://hrm.pragmatictestlabs.com";

    @Test
    public void testInGoogleChrome(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(BASE_URL);
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");
        driver.findElement(By.id("btnLogin")).click();
        String welcomeMessage = driver.findElement(By.id("welcome")).getText();
        assertThat(welcomeMessage).isEqualTo("Welcome Admin");
        driver.close();
    }

    @Test
    public void testInFirefox(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get(BASE_URL);
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");
        driver.findElement(By.id("btnLogin")).click();
        String welcomeMessage = driver.findElement(By.id("welcome")).getText();
        assertThat(welcomeMessage).isEqualTo("Welcome Admin");
        driver.close();
    }

    @Test
    public void testInSafari(){
        WebDriverManager.safaridriver().setup();
        WebDriver driver = new SafariDriver();
        driver.get(BASE_URL);
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");
        driver.findElement(By.id("btnLogin")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("welcome")));
        String welcomeMessage = driver.findElement(By.id("welcome")).getText();
        assertThat(welcomeMessage).isEqualTo("Welcome Admin");
        driver.close();
    }






}
