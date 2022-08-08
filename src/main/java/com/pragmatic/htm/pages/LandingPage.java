package com.pragmatic.htm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    private final WebDriver driver;
    @FindBy(id = "welcome")
    private WebElement lnkWelcome;

    @FindBy(linkText = "Logout")
    private WebElement lnkLogout;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }


    public String getWelcomeMessage() {
        return lnkWelcome.getText();
    }

    public void logout()  {
        lnkWelcome.click();
        lnkLogout.click();
    }
}
