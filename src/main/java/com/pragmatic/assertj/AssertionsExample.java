package com.pragmatic.assertj;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertionsExample {

    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

    @Test
    public void useAssertJAssertions() {
        driver.navigate().to("https://www.saucedemo.com");
        assertThat(driver.getTitle())
                .as("Title verification failed")
                .containsIgnoringCase("Swag Labs")
                .startsWith("Swag")
                .endsWith("Labs")
                .endsWithIgnoringCase("labs");

        WebElement loginCredentials = driver.findElement(By.cssSelector("div.login_credentials"));
        String[] userNames = loginCredentials.getText().split("\n");

        for (int i = 1; i < userNames.length; i++) {
            System.out.println(userNames[i]);
        }

        String[] password = driver.findElement(By.cssSelector("div.login_password")).getText().split("\n");


        assertThat(userNames)
                .containsSequence("standard_user", "locked_out_user", "problem_user", "performance_glitch_user")
                .doesNotContain("Admin")
                .hasSize(5);

        driver.findElement(By.id("user-name")).sendKeys(userNames[1]);
        driver.findElement(By.id("password")).sendKeys(password[1]);
        driver.findElement(By.id("login-button")).click();

        List<WebElement> inventoryItemsList = driver.findElements(By.cssSelector("div.inventory_item"));

        for (WebElement item : inventoryItemsList) {
            System.out.println(item.findElement(By.cssSelector("div.inventory_item_name")).getText());
            System.out.println(item.findElement(By.cssSelector("div.inventory_item_desc")).getText());
            System.out.println(item.findElement(By.cssSelector("div.inventory_item_price")).getText());
        }

        inventoryItemsList.stream()
                .filter(item -> Float.parseFloat(item.findElement(By.cssSelector("div.inventory_item_price")).getText().replace("$", "")) > 10.0)
                .forEach(item -> System.out.println(item.findElement(By.cssSelector("div.inventory_item_name")).getText()));




    }
}
