package com.pragmatic;

public enum BrowserTypes {
    CHROME("Google Chrome"),
    FIREFOX("Mozilla Firefox"),
    SAFARI("Safari"),
    IE("Internet Explorer"),
    EDGE ("Microsoft Edge"),
    OPERA("Opera"),
    CHROME_HEADLESS("Chrome headless"),
    FIREFOX_HEADLESS("Firefox headless");

    final String browserName;

    BrowserTypes(String browserName) {
        this.browserName = browserName;
    }
}
