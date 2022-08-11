package com.pragmatic.selenium.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JSExecutorExample {


    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("http://hrm.pragmatictestlabs.com/");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }


    @Test
    public void testLoginWIthJSExecutorID() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('txtUsername').value='Admin';");
        js.executeScript("document.getElementById('txtPassword').value='Ptl@#321';");
        js.executeScript("document.getElementById('btnLogin').click();");

        var welcomeMessage = js.executeScript("return document.getElementById('welcome').innerText;");
        assertThat(welcomeMessage).isEqualTo("Welcome Admin");
    }

    @Test
    public void testLoginWIthJSExecutorCSS() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#txtUsername').value='Admin';");
        js.executeScript("document.querySelector('#txtPassword').value='Ptl@#321';");
        js.executeScript("document.querySelector('#btnLogin').click();");


        var welcomeMessage = js.executeScript("return document.querySelector('#welcome').innerText;");
        assertThat(welcomeMessage).isEqualTo("Welcome Admin");
    }

    @Test
    public void testPageTitle() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        var pageTitle = js.executeScript("return document.title;");
        assertThat(pageTitle).isEqualTo("PTL-DemoHRM");
    }

    @Test
    public void testDomainName() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        var domainName = js.executeScript("return document.domain;");
        assertThat(domainName).isEqualTo("hrm.pragmatictestlabs.com");
    }


    @Test
    public void testScrollElementToView() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.location = 'https://www.w3schools.com/jsref/met_element_scrollintoview.asp';");
        js.executeScript("document.querySelector(\"a[href$='conversion.asp']\").scrollIntoView();");
        WebElement element = (WebElement) js.executeScript("return document.querySelector(\"a[href$='conversion.asp']\");");
        System.out.println(element.getAttribute("href"));

    }


}
