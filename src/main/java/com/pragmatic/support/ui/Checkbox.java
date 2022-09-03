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
