package com.pragmatic.hrm;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

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
                webDriver = new ChromeDriver();
            }
            case "firefox" -> {
                webDriver = new FirefoxDriver();
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
        return webDriver;
    }

    public void closeBrowserWindows() {
        if (webDriver!=null){
            webDriver.quit();
        }
    }
}
