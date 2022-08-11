package com.pragmatic.selenium.jspopups;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This example demonstrate working with JavaScript popup boxes
 *
 */
public class JSPopupsExample {


    private WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.get("http://demosite.pragmatictestlabs.com/");
        driver.findElement(By.id("btnJSPopups")).click();
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }


    @Test
    public void testAlerts(){
        driver.findElement(By.id("alert")).click();
        Alert alert = driver.switchTo().alert();
        assertThat(alert.getText()).isEqualTo("This is a simple Alert");
        alert.accept();
        String message = driver.findElement(By.id("confirm-demo")).getText();
        assertThat(message).isEqualTo("Alert was closed!");
    }


    @Test
    public void testConfirmationOK(){
        driver.findElement(By.id("confirmation")).click();
        Alert confirmation = driver.switchTo().alert();
        assertThat(confirmation.getText()).isEqualTo("Press a button!");
        confirmation.accept();
        String message = driver.findElement(By.id("confirm-demo")).getText();
        assertThat(message).isEqualTo("It was confirmed!");
    }


    @Test
    public void testConfirmationCancel(){
        driver.findElement(By.id("confirmation")).click();
        Alert confirmation = driver.switchTo().alert();
        assertThat(confirmation.getText()).isEqualTo("Press a button!");
        confirmation.dismiss();
        String message = driver.findElement(By.id("confirm-demo")).getText();
        assertThat(message).isEqualTo("It was rejected!");
    }

    @Test
    public void testPrompt(){
        String firstName = (new Faker()).name().firstName();
        driver.findElement(By.id("prompt")).click();
        Alert prompt = driver.switchTo().alert();
        assertThat(prompt.getText()).isEqualTo("Please enter your name");
        prompt.sendKeys(firstName);
        prompt.accept();
        String message = driver.findElement(By.id("confirm-demo")).getText();
        assertThat(message).isEqualTo(String.format("Your name is %s", firstName ));
    }


    @Test
    public void testTimingAlerts(){
        driver.findElement(By.id("timingAlert")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        assertThat(alert.getText()).isEqualTo("This is a timing alert!");
        alert.accept();
        String message = driver.findElement(By.id("confirm-demo")).getText();
        assertThat(message).isEqualTo("Timing alert was closed!");
    }



}
