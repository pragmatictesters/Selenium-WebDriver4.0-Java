# Selenium WebDriver : Custom Elements 
You can create your own custom WebElements in Selenium WebDriver. This gives you additional flexibility when working with web elements. 
All complexities can be hidden inside the custom WebElements.

You can see an implementation in the Selenium support class, Select class. We can use the Select as base to create our custom WebElements.

## Steps 
1. Create an Interface for the WebElement with all abstract methods for the WebElement.
2. Create a class for new custom element by extending the new interface (step 1) and WrapsElement
3. Implement the constructor and implement the methods with the desired functionality

## Sample Interface 
Following is a sample interface for checkbox
```java
package com.pragmatic.support.ui;

public interface ICheckbox {
    public void check();

    public void uncheck();
    public boolean isChecked();

    public void toggle();
}
```
## Custom WebElement 
Following is a sample custom WebElement
```java
package com.pragmatic.support.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;

public class Checkbox implements ICheckbox, WrapsElement {
    private final WebElement element;

    public Checkbox(WebElement element) {
        this.element = element;
    }
    
    @Override
    public WebElement getWrappedElement() {
        return element;
    }

    @Override
    public void check() {
        if (!element.isSelected()){
            element.click();
        }
    }

    @Override
    public void uncheck() {
        if (element.isSelected()){
            element.click();
        }
    }

    @Override
    public boolean isChecked() {
        return element.isSelected();
    }
    
    @Override
    public void toggle() {
        element.click();
    }
}

```
## Using the custom WebElement 
Following demonstrates the use of custom WebElement. 

```java
package com.pragmatic.examples;

import com.pragmatic.support.ui.Button;
import com.pragmatic.support.ui.Checkbox;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementsAbstractionExample {
    
    private WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.get("http://demosite.pragmatictestlabs.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("btnRegister")).click();

    }
    
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
    
    @Test
    public void testCheckbox (){
        WebElement eleSeleniumCheck = driver.findElement(By.id("selenium"));
        Checkbox chkSelenium = new Checkbox(eleSeleniumCheck);
        chkSelenium.check();
        Assert.assertEquals(chkSelenium.isChecked(), true);
        chkSelenium.uncheck();
        Assert.assertEquals(chkSelenium.isChecked(), false);
        chkSelenium.toggle();
        Assert.assertEquals(chkSelenium.isChecked(), true);
        chkSelenium.toggle();
        Assert.assertEquals(chkSelenium.isChecked(), false);
        chkSelenium.check();
        Assert.assertEquals(chkSelenium.isChecked(), true);
        chkSelenium.uncheck();
        Assert.assertEquals(chkSelenium.isChecked(), false);
    }
    
}

```

## Sample Custom Elements 
Custom elements can be found in the com.pragmatic.support.ui package.
Following custom locators are available
1. Checkbox.java
2. Button.java 

## References 
[Java API : WrapsElement](https://www.selenium.dev/selenium/docs/api/java/index.html?org/openqa/selenium/WrapsElement.html)
