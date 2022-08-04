package com.pragmatic.selenium.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
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

public class BrowserWindow {


    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

    @Test
    public void useBrowserNavigationOptions() {
        driver.navigate().to("http://hrm.pragmatictestlabs.com");
        driver.manage().window().maximize();
        displayWindowSize();
        setSize();

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        setPosition();
        driver.manage().window().minimize();
        displayWindowSize();

        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");
        driver.manage().window().fullscreen();
        displayWindowSize();

        driver.findElement(By.id("btnLogin")).click();
        displayWindowSize();
    }


    private void setSize(){
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
        driver.manage().window().setSize(new Dimension(width/2, height));
    }

    private void setPosition(){
        int width = driver.manage().window().getSize().getWidth();
        int x = driver.manage().window().getPosition().getX() + width/2;
        int y = driver.manage().window().getPosition().getY();
        driver.manage().window().setPosition(new Point(x, y));
    }

    private void displayWindowSize(){
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getHeight();

        System.out.printf("Height %s : Width %s\n", height, width);
    }
}
