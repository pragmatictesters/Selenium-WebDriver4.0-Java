package com.pragmatic.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    @FindBy(id = "txtUsername")
    private WebElement txtUsername;

    @FindBy(id = "txtPassword")
    private WebElement txtPassword;

    @FindBy(id = "btnLogin")
    private WebElement btnLogin;

    @FindBy(id = "spanMessage")
    private WebElement lblError;


    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public LoginPage typeUsername(String username) {
        txtUsername.sendKeys((username));
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
