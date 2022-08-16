package com.rootcode.waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumWaitsExample {


    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("http://hrm.pragmatictestlabs.com");
        login();
    }

    private void login() {
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");
        driver.findElement(By.id("btnLogin")).click();
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }


    @Test
    public void testLogoutWithoutWaits() {
        driver.findElement(By.id("welcome")).click();
        //This will fail with No such element present exception
        driver.findElement(By.linkText("Logout")).click();
        Assert.assertTrue(driver.findElement(By.id("txtUsername")).isDisplayed());
    }

    @Test
    public void testLogoutWithoutWaitsErrorCheck() {
        driver.findElement(By.id("welcome")).click();
        Assert.assertThrows(NoSuchElementException.class, () ->
                driver.findElement(By.linkText("Logout")).click()
        );
    }

    @Test
    public void testLogoutWithSleep() throws InterruptedException {
        driver.findElement(By.id("welcome")).click();
        Thread.sleep(5000); //NEVER USE THIS
        driver.findElement(By.linkText("Logout")).click();
        Assert.assertTrue(driver.findElement(By.id("txtUsername")).isDisplayed());
    }

    @Test
    public void testLogoutWithImplicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //AVOID USING THIS.
        driver.findElement(By.id("welcome")).click();
        driver.findElement(By.linkText("Logout")).click();
        Assert.assertTrue(driver.findElement(By.id("txtUsername")).isDisplayed());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
    }


    @Test
    public void testLogoutWithExplicitWait()  {
        driver.findElement(By.id("welcome")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(
                ExpectedConditions.elementToBeClickable(By.linkText("Logout"))
        ).click();

        //driver.findElement(By.linkText("Logout")).click();
        Assert.assertTrue(driver.findElement(By.id("txtUsername")).isDisplayed());
    }


     @Test
    public void testLogoutWithFluentWait() {
        driver.findElement(By.id("welcome")).click();

         Wait<WebDriver> wait = new FluentWait<>(driver)
                 .withTimeout(Duration.ofSeconds(10))
                 .withMessage("Logout element is not found")
                 .pollingEvery(Duration.ofMillis(200))
                 .ignoring(NoSuchElementException.class);

        wait.until(
                ExpectedConditions.elementToBeClickable(By.linkText("Logout"))
        ).click();

        //driver.findElement(By.linkText("Logout")).click();
        Assert.assertTrue(driver.findElement(By.id("txtUsername")).isDisplayed());
    }





}
