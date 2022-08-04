package com.pragmatic.selenium.timeouts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TimeoutExample {

    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

    @Test
    public void useBrowserNavigationOptions() {
        driver.navigate().to("http://hrm.pragmatictestlabs.com");
        driver.manage().window().maximize();
        System.out.printf("Default implicit wait timeout %s\n",driver.manage().timeouts().getImplicitWaitTimeout().getSeconds());
        System.out.printf("Default page load timeout %s\n",driver.manage().timeouts().getPageLoadTimeout().getSeconds());
        System.out.printf("Default script timeout %s\n",driver.manage().timeouts().getScriptTimeout().getSeconds());

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
    }

}
