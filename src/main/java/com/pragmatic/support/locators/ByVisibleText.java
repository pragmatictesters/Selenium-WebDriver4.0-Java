package com.pragmatic.support.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ByVisibleText extends By {
    private final String exactText;

    public ByVisibleText(String exactText) {
        this.exactText = exactText;
    }

    @Override
    public List<WebElement> findElements(SearchContext context) {
        return context
                .findElements(
                        By.xpath(String.format("//*[text()='%s']", exactText)));
    }
}
