package com.pragmatic.selenium.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
        driver.findElement(By.id("btnDragAndDrop")).click();
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }


    @Test
    public void testAlerts(){
        WebElement srcElement = driver.findElement(By.id("draggableview"));
        WebElement targetElement = driver.findElement(By.id("droppableview"));

        Actions actions = new Actions(driver);

        actions.dragAndDrop(srcElement, targetElement)
                .perform();
        String message = driver.findElement(By.id("droppableview")).getText();
        assertThat(message).isEqualTo("Dropped!");

    }
}
