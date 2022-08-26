package com.rootcode.sauce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final WebDriver driver;

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement txtUserName;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement txtPassword;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement btnLogin;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement lblError;



    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public LoginPage typeUsername(String username) {
        txtUserName.sendKeys(username);
        return this;
    }


    public LoginPage typePassword(String password) {
        txtPassword.sendKeys(password);
        return this;
    }


    public void clickLogin() {
        btnLogin.click();
    }

    public String getError() {
        return lblError.getText();
    }
}
