package com.pragmatic.assertj;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class URLAssertionExample {


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
    public void useBrowserNavigationOptions() throws URISyntaxException {
        driver.get("http://hrm.pragmatictestlabs.com");
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");
        driver.findElement(By.id("btnLogin")).click();
       assertThat(new URI(driver.getCurrentUrl()))
               .hasNoPort()
               .hasHost("hrm.pragmatictestlabs.com")
               .hasPath("/symfony/web/index.php/dashboard")
               .hasNoParameters();


    }
}
