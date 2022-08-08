package com.rootcode.hrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPage {
    private final WebDriver driver;

    @FindBy(id ="welcome")
    private WebElement lnkWelcome;

    @FindBy(linkText ="Logout")
    private WebElement lnkLogout;




    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getWelcomeMessage(){
        return lnkWelcome.getText();
    }

    public void logout() {
        lnkWelcome.click();
        //USE EXPLICIT WAIT
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Logout"))).click();
        lnkLogout.click();
    }
}
