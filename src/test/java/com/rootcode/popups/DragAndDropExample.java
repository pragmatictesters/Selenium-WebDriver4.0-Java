package com.rootcode.popups;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DragAndDropExample {


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

    }


    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }



    @Test
    public void testDragAndDrop(){
        driver.findElement(By.id("btnDragAndDrop")).click();
        //Get the source element
        WebElement sourceElement = driver.findElement(By.id("draggableview"));

        //Get the target element
        WebElement targetElement = driver.findElement(By.id("droppableview"));

        //Use Actions class for drag and drop
        Actions actions = new Actions(driver);

        actions.dragAndDrop(sourceElement, targetElement)
                .perform();

        String messageAfterDrop =  driver.findElement(By.id("droppableview")).findElement(By.tagName("p")).getText();
        Assert.assertEquals(messageAfterDrop, "Dropped!");

    }





}
