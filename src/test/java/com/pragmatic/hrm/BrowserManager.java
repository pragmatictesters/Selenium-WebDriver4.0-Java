package com.pragmatic.hrm;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BrowserManager {

    private  WebDriver webDriver ;
    public  void setupDriver(String browserName) {

        switch (browserName.toLowerCase()) {
            case "chrome", "chrome_headless" -> {
                WebDriverManager.chromedriver().setup();
            }
            case "firefox", "firefox_headless" -> {
                WebDriverManager.firefoxdriver().setup();
            }case "safari" -> {
                WebDriverManager.safaridriver().setup();
            }case "ie", "internet_explorer" -> {
                WebDriverManager.iedriver().setup();
            } case "edge" -> {
                WebDriverManager.edgedriver().setup();
            }
            default -> throw new IllegalArgumentException(String.format("Invalid browser name ", browserName));
        }
    }

    public  WebDriver launchBrowser(String browser) {

        switch (browser.toLowerCase()) {
            case "chrome" -> {
                ChromeOptions options = new ChromeOptions();
                //Removing the Infobar
                options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));

                //Disabling save password popup window
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                options.setExperimentalOption("prefs", prefs);
                options.addArguments("--disable-save-password");
                webDriver = new ChromeDriver(options);
            }case "chrome-headless" -> {
                ChromeOptions options = new ChromeOptions();
                options.setHeadless(true);
                webDriver = new ChromeDriver(options);
            }
            case "firefox" -> {
                webDriver = new FirefoxDriver();
            } case "firefox-headless" -> {
                FirefoxOptions options = new FirefoxOptions();
                options.setHeadless(true);
                webDriver = new FirefoxDriver(options);
            }
            case "safari" -> {
                webDriver = new SafariDriver();
            }
            case "ie", "internet_explorer" -> {
                webDriver = new InternetExplorerDriver();
            }
            case "edge" -> {
                webDriver = new EdgeDriver();
            }

        }
        webDriver.manage().window().maximize();
        return webDriver;
    }

    public void closeBrowserWindows() {
        if (webDriver!=null){
            webDriver.quit();
        }
    }
}
