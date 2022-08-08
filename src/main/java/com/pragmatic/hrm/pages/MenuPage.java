package com.pragmatic.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MenuPage {
    private final WebDriver driver;

    @FindBy(linkText = "PIM")
    private WebElement lnkMnuPIM;

    @FindBy(linkText = "Add Employee")
    private WebElement lnkMnuAddEmployee;


    public MenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public MenuPage navigateToAddEmployeePage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        lnkMnuPIM.click();
        lnkMnuAddEmployee.click();
        return this;
    }
}
