package com.pragmatic.selenium.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
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
 * This example demonstrate use of WebDriver.Interface
 * Refer to <a src="https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html">WebDriver.Interface</a>
 */
public class BrowserNavigation {

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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void useBrowserNavigationOptions() {
        driver.navigate().to("http://hrm.pragmatictestlabs.com");
        //driver.get("http://hrm.pragmatictestlabs.com");
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Ptl@#321");
        driver.findElement(By.id("btnLogin")).click();
        assertThat(driver.getCurrentUrl()).containsIgnoringCase("/web/index.php/dashboard");
        driver.navigate().back();
        assertThat(driver.getCurrentUrl()).doesNotContainIgnoringCase("/web/index.php/dashboard");
        assertThat(driver.getCurrentUrl()).containsIgnoringCase("/web/index.php/auth/login");
        driver.navigate().forward();
        assertThat(driver.getCurrentUrl()).containsIgnoringCase("/web/index.php/dashboard");

        driver.findElement(By.id("welcome")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Logout")));
        driver.findElement(By.linkText("Logout")).click();
        assertThat(driver.getCurrentUrl()).containsIgnoringCase("/web/index.php/auth/login");
        driver.navigate().refresh();
        driver.navigate().back();
        assertThat(driver.getCurrentUrl()).containsIgnoringCase("/web/index.php/auth/login");
        driver.navigate().forward();
        assertThat(driver.getCurrentUrl()).containsIgnoringCase("/web/index.php/auth/login");


    }


}
