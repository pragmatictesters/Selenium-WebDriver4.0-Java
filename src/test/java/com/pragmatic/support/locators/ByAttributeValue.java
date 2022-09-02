package com.pragmatic.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LocateByAttribute extends By {
    private final String name;
    private final String value;

    public LocateByAttribute(String attributeName, String attributeValue) {
        this.name= attributeName;
        this.value= attributeValue;
    }

    @Override
    public List<WebElement> findElements(SearchContext context) {
        return context.findElements(By.cssSelector(String.format("[%s='%s']", name,value)));
    }
}
