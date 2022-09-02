package com.pragmatic.support.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ByPartialVisibleText extends By {
    private final String partialText;

    public ByPartialVisibleText(String partialText) {
        this.partialText = partialText;
    }

    @Override
    public List<WebElement> findElements(SearchContext context) {
        return context.findElements(By.xpath(String.format("//*[contains(text(), '%s')]", partialText)));
    }
}
