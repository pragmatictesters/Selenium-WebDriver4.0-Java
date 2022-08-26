package com.rootcode.sauce.tests;

import com.rootcode.sauce.SauceDataProvider;
import com.rootcode.sauce.TestBase;
import com.rootcode.sauce.pages.InventoryPage;
import com.rootcode.sauce.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class LoginTest extends TestBase {

    @Test
    public void testUserLoginWithValidCredentials(){
        LoginPage loginPage = new LoginPage(super.getDriver());
        loginPage.typeUsername("standard_user").typePassword("secret_sauce").clickLogin();
        InventoryPage inventoryPage = new InventoryPage(super.getDriver());
        Assert.assertEquals(inventoryPage.getTitle(), "PRODUCTS");
    }

    @Test(dataProvider = "invalid-login-inputs", dataProviderClass = SauceDataProvider.class)
    public void testUserLoginWithInvalidCredentials(String username, String password, String expectedError){
        LoginPage loginPage = new LoginPage(super.getDriver());
        loginPage.typeUsername(username).typePassword(password).clickLogin();
        assertThat(loginPage.getError()).containsPattern(expectedError);
    }









}
