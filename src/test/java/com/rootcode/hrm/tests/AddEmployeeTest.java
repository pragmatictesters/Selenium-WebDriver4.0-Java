package com.rootcode.hrm.tests;

import com.github.javafaker.Faker;
import com.rootcode.hrm.HRMBaseTest;
import com.rootcode.hrm.pages.AddEmployeePage;
import com.rootcode.hrm.pages.MenuPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddEmployeeTest extends HRMBaseTest {


    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        //Login to the system
        driver = new ChromeDriver();
        driver.get("http://hrm.pragmatictestlabs.com");
        super.login(driver);
        //Navigating to the add employee page
        MenuPage menuPage = new MenuPage(driver);
        menuPage.navigateToAddEmployeePage();
    }


    @AfterMethod
    public void afterMethod(){
//        if (driver!=null){
//            driver.quit();
//        }
    }


    @Test()
    public void testAddEmployeeWithMandatoryInformation(){
        AddEmployeePage addEmployeePage = new AddEmployeePage(driver);

        addEmployeePage.typeFirstName("Janesh")
                .typeLastName("Kodikara")
                .clickSave();

    }


    @Test()
    public void testAddEmployeeWithMandatoryInformationAndProfilePicture(){
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();


        AddEmployeePage addEmployeePage = new AddEmployeePage(driver);
        addEmployeePage.typeFirstName(firstName)
                .typeLastName(lastName)
                .uploadProfilePicture("/Users/admin/Documents/training/cucumber/ptl-selenium/src/test/resources/pics/sample-profile-pic.jpeg")
                .clickSave();

    }


    @Test()
    public void testAddEmployeeWithLoginCredentials(){
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userName = String.format("%s.%s", firstName, lastName);
        String password = "Ptl@#321";


        AddEmployeePage addEmployeePage = new AddEmployeePage(driver);
        addEmployeePage.typeFirstName(firstName)
                .typeLastName(lastName)
                .checkLoginCredentials()
                .typeUsername(userName)
                .typePassword(password)
                .typeRePassword(password)
                .selectStatus("Enabled")
                .clickSave();

        //Use the login information to login to the system and show new employee can login

    }






    @Test()
    public void testAddEmployeeWithAllEmployeeInformation(){

    }




}
