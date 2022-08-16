package com.pragmatic.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomLocatorsExample {



    @Test
    public void testCustomLocator(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://hrm.pragmatictestlabs.com");
        WebElement txtUsername = driver.findElement(new LocateByAttribute("id","txtUsername"));
//        WebElement txtUsername = driver.findElement(By.id("txtUsername"));

        String userInput = "Janesh";
        txtUsername.sendKeys(userInput);

        Assert.assertEquals(txtUsername.getAttribute("value"), userInput);
        driver.close();
    }


}
