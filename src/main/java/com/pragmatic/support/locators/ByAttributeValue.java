package com.pragmatic.support.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ByAttributeValue extends By {
    private final String name;
    private final String value;

    public ByAttributeValue(String attributeName, String attributeValue) {
        this.name= attributeName;
        this.value= attributeValue;
    }

    @Override
    public List<WebElement> findElements(SearchContext context) {
        return context.findElements(By.cssSelector(String.format("[%s='%s']", name,value)));
    }
}
