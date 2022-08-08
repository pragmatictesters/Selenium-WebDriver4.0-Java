package com.pragmatic.hrm.tests.pim;

import com.pragmatic.hrm.BaseTest;
import com.pragmatic.hrm.BrowserManager;
import com.pragmatic.hrm.pages.AddEmployeePage;
import com.pragmatic.hrm.pages.MenuPage;
import com.pragmatic.util.RandomDataManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddEmployeeTest extends BaseTest {


    private BrowserManager browserManager;
    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        browserManager = new BrowserManager();
        driver = browserManager.launchBrowser("chrome");
        driver.get("http://hrm.pragmatictestlabs.com");
        super.login(driver);
        MenuPage menuPage = new MenuPage(driver);
        menuPage.navigateToAddEmployeePage();
    }

    @AfterMethod
    public void afterMethod(){
        browserManager.closeBrowserWindows();
    }


    @Test
    public void testAddEmployeeWithMandatoryInformation() {

        AddEmployeePage addEmployeePage = new AddEmployeePage(driver);
        addEmployeePage
                .typeFirstName(RandomDataManager.getFirstName())
                .typeLastName(RandomDataManager.getLastName())
                .clickSave();
    }
}
