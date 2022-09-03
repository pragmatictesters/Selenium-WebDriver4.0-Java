package com.pragmatic.examples;

import com.pragmatic.support.ui.Button;
import com.pragmatic.support.ui.Checkbox;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementsAbstractionExample {


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
        driver.findElement(By.id("btnRegister")).click();

    }


    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

    @Test
    public void testSelectFromDropDown(){
        WebElement eleContinents = driver.findElement(By.id("continents"));
        Select selContinents = new Select(eleContinents);
        selContinents.selectByVisibleText(" Asia ");
        selContinents.selectByValue("Australia");
        selContinents.selectByIndex(3);
    }

    @Test
    public void testButton(){
        WebElement eleSubmitButton = driver.findElement(By.id("btnsubmit"));
        Button btnSubmit = new Button(eleSubmitButton);
        Assert.assertEquals(btnSubmit.getText(), "Submit");
    }



    @Test
    public void testCheckbox (){
        WebElement eleSeleniumCheck = driver.findElement(By.id("selenium"));
        WebElement eleSQTPCheck = driver.findElement(By.id("qtp"));
        Checkbox chkSelenium = new Checkbox(eleSeleniumCheck);
        Checkbox chkQTP = new Checkbox(eleSQTPCheck);
        chkSelenium.check();
        Assert.assertEquals(chkSelenium.isChecked(), true);
        chkSelenium.uncheck();
        Assert.assertEquals(chkSelenium.isChecked(), false);
        chkSelenium.toggle();
        Assert.assertEquals(chkSelenium.isChecked(), true);
        chkSelenium.toggle();
        Assert.assertEquals(chkSelenium.isChecked(), false);
        chkSelenium.check();
        Assert.assertEquals(chkSelenium.isChecked(), true);
        chkSelenium.uncheck();
        Assert.assertEquals(chkSelenium.isChecked(), false);
    }




}
