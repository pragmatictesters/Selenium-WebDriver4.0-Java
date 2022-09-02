package com.pragmatic.examples;

import com.pragmatic.support.locators.ByAttributeValue;
import com.pragmatic.support.locators.ByPartialVisibleText;
import com.pragmatic.support.locators.ByVisibleText;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CustomLocatorExample {


    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("http://demosite.pragmatictestlabs.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Test
    public void testCustomLocatorLocateByVisibleText() {
        WebElement btnRegister = driver.findElement(new ByVisibleText("Register Page"));
        Assert.assertEquals(btnRegister.getTagName(), "button");
    }

    @Test
    public void testCustomLocatorLocateByPartialVisibleText() {
        WebElement btnRegister = driver.findElement(new ByPartialVisibleText("Register"));
        Assert.assertEquals(btnRegister.getTagName(), "button");
    }

    @Test
    public void testCustomLocatorLocateByAttributeValue() {
        WebElement btnRegister = driver.findElement(new ByAttributeValue("id", "btnRegister"));
        Assert.assertEquals(btnRegister.getTagName(), "button");
    }


}
