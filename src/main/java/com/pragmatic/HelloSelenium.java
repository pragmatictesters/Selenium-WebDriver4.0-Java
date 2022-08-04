package com.pragmatic;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Solution for Day2 question 1
 * Open a web browser and login https://www.saucedemo.com
 *
 * Refer to
 * <a href="https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/WebDriver.html">WebDriver</a>
 * <a href="https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/WebElement.html">WebElement</a>
 *
 */
public class HelloSelenium {


    public static final String BASE_URL = "https://www.saucedemo.com";

    public static void main(String[] args) throws InterruptedException {
        String username = "standard_user";
        String password = "secret_sauce";

        //Setup chrome driver. We use WebDriverManager to set up the driver
        WebDriverManager.chromedriver().setup();

        //Launch browser. We code for WebDriver interface
        WebDriver driver = new ChromeDriver();

        //Maximize the browser window. Also, you can minimize the window
        driver.manage().window().maximize();

        //Navigate to the URL
        driver.get(BASE_URL);
        //driver.navigate().to(BASE_URL);//Another option available

        //Locate the username input By ID and type a username

        driver.findElement(By.id("user-name")).sendKeys(username);

        //Locate the password filed BY name and type password
        driver.findElement(By.name("password")).sendKeys(password);

        ///Submit the login form. We have many options

        //1. Click the LOGIN button. This time we locate the button with a class name
        driver.findElement(By.className("submit-button")).click();

        //2. Press the enter key after typing the password
        //driver.findElement(By.name("password")).sendKeys(password + Keys.ENTER);

        //3. Invoke the form submit with any element within the form. We select password
        //driver.findElement(By.name("password")).submit();

        //Let's wait for sometime before closing the window
        Thread.sleep(5000);

        //Close the browser
        driver.close();//Close the current window. Quit only if current is the last/only window
        //driver.quit(); //Closes every associated window and quit the driver


    }
}
