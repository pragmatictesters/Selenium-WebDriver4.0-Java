package com.pragmatic.support;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;

public class Button implements IButton, WrapsElement {
    private final WebElement element;

    public Button(WebElement element) {
        this.element = element;
    }


    @Override
    public WebElement getWrappedElement() {
        return element;
    }

    @Override
    public void click() {
        element.click();
    }

    @Override
    public String getText() {
        return element.getText().strip();

    }
}
