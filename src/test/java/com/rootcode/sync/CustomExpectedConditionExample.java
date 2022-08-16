package com.rootcode.sync;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CustomExpectedConditionExample {


    private WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.get("https://eviltester.github.io/supportclasses/#5000");
    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
    }

    @Test
    public void testMessageCountIncreaseWithCustomExpectedCondition(){
        driver.findElement(By.id("resend-select")).click();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                historyMessagesIncreaseInNumber()
        );
        WebElement eleMessage = driver.findElement(By.cssSelector("#single-list>li.message"));
        Assert.assertTrue(eleMessage.getText().startsWith("Received message:"));
    }

    private ExpectedCondition<Boolean> historyMessagesIncreaseInNumber() {
        int initialCount = driver.findElements(By.cssSelector("#single-list>li.message")).size();
        System.out.printf("Initial count %s\n", initialCount);

        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                int currentCount = driver.findElements(By.cssSelector("#single-list>li.message")).size();
                System.out.printf("Current count %s\n", currentCount);
                return currentCount> initialCount;
            }
        };
    }
}
