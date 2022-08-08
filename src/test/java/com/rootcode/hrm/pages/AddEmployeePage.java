package com.rootcode.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddEmployeePage {
    private final WebDriver driver;

    @FindBy(id = "firstName")
    private WebElement txtFirstname;

    @FindBy(id = "lastName")
    private WebElement txtLastname;

    @FindBy(id = "photofile")
    private WebElement profilePicElement;

    @FindBy(id = "chkLogin")
    private WebElement chkLogin;

    @FindBy(id = "user_name")
    private WebElement txtUsername;

    @FindBy(id = "user_password")
    private WebElement txtPassword;

    @FindBy(id = "re_password")
    private WebElement txtRePassword;


    @FindBy(id = "status")
    private WebElement lstStatus;


    @FindBy(id = "btnSave")
    private WebElement btnSave;


    public AddEmployeePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AddEmployeePage typeFirstName(String firstName) {
        txtFirstname.click();
        txtFirstname.sendKeys(firstName);
        return this;
    }

    public AddEmployeePage typeLastName(String lastName) {
        txtLastname.click();
        txtLastname.sendKeys(lastName);
        return this;
    }

    public void clickSave() {
        btnSave.click();
    }

    public AddEmployeePage uploadProfilePicture(String filePath) {
        profilePicElement.sendKeys(filePath);
        return this;
    }

    public AddEmployeePage checkLoginCredentials() {
        chkLogin.click(); //NOT THE BEST WAY
        return this;
    }

    public AddEmployeePage typeUsername(String userName) {
        txtUsername.clear();
        txtUsername.sendKeys(userName);
        return this;
    }

    public AddEmployeePage typePassword(String password) {
        txtPassword.clear();
        txtPassword.sendKeys(password);
        return this;
    }


    public AddEmployeePage typeRePassword(String password) {
        txtRePassword.clear();
        txtRePassword.sendKeys(password);
        return this;
    }


    public AddEmployeePage selectStatus(String status) {
        //Working with Select
        Select selStatus = new Select(lstStatus);
        selStatus.selectByIndex(1);
        selStatus.selectByValue("Enabled");
        selStatus.selectByVisibleText(status);
        return this;
    }
}
