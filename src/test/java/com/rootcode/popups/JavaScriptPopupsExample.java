package com.rootcode.popups;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class JavaScriptPopupsExample {


    private WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.get("http://demosite.pragmatictestlabs.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("btnJSPopups")).click();
    }


    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

    @Test
    public void testSimpleAlert(){
        driver.findElement(By.id("alert")).click();
        //Get alert popup or Switch to the alert window
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        Assert.assertEquals(message, "This is a simple Alert");

        //Click the OK button
        alert.accept();   //Check what will happen if you do  alert.dismiss();
        String confirmation = driver.findElement(By.id("confirm-demo")).getText();
        Assert.assertEquals(confirmation.strip(), "Alert was closed!");
    }


    @Test
    public void testConfirmationOK(){
        //Homework

    }

    @Test
    public void testConfirmationCancel(){
        driver.findElement(By.id("confirmation")).click();
        Alert confirmPopup = driver.switchTo().alert();
        String message = confirmPopup.getText();
        Assert.assertEquals(message, "Press a button!");
        confirmPopup.dismiss();

        String confirmation = driver.findElement(By.id("confirm-demo")).getText();
        Assert.assertEquals(confirmation.strip(), "It was rejected!");
    }


     @Test
    public void testPrompt(){
         Faker faker = new Faker();
         String firstName = faker.name().firstName();

        driver.findElement(By.id("prompt")).click();
         Alert promptPopup = driver.switchTo().alert();
         //Homework check the message

         //Typing text
         promptPopup.sendKeys(firstName);
         promptPopup.accept();
         String confirmation = driver.findElement(By.id("confirm-demo")).getText();
         Assert.assertEquals(confirmation.strip(), String.format("Your name is %s", firstName));
    }


    @Test
    public void testSimpleAlertsWithTiming(){
        driver.findElement(By.id("timingAlert")).click();

        //We need to wait till the alert is present
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());

        //Get alert popup or Switch to the alert window
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        Assert.assertEquals(message, "This is a timing alert!");

        //Click the OK button
        alert.accept();   //Check what will happen if you do  alert.dismiss();
        String confirmation = driver.findElement(By.id("confirm-demo")).getText();
        Assert.assertEquals(confirmation.strip(), "Timing alert was closed!");
    }





}
