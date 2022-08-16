package com.rootcode.popups;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsClassExample {


    private WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

    }


    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }



    @Test
    public void testTypeWithShiftKeyDown() throws InterruptedException {

        WebElement element = driver.findElement(By.cssSelector("#login_credentials>h4"));
        WebElement txtUsername = driver.findElement(By.cssSelector("#user-name"));

        //Use Actions class for drag and drop
        Actions actions = new Actions(driver);

        String userInput = "username";
        actions.keyDown(txtUsername, Keys.SHIFT)
                .sendKeys(txtUsername, userInput)
                .keyUp(Keys.SHIFT)
                .perform();
        Assert.assertEquals(txtUsername.getAttribute("value"),userInput.toUpperCase() );
    }








}
