package com.rootcode.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {
    private final WebDriver driver;

    @FindBy(id="menu_pim_viewPimModule")
    private WebElement lnkMnuPIM;

     @FindBy(id="menu_pim_addEmployee")
    private WebElement lnkMnuAddEmployee;


    public MenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public MenuPage navigateToAddEmployeePage() {
        lnkMnuPIM.click();
        lnkMnuAddEmployee.click();
        return this;
    }
}
