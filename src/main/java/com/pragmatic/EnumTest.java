package com.pragmatic;

public class EnumTest {


    public static void main(String[] args) {
        BrowserTypes browserTypes = BrowserTypes.OTHER;

        switch (browserTypes) {
            case IE -> System.out.println("Internet explorer ");
            case EDGE -> System.out.println("Edge");
            case CHROME -> System.out.println("Google chrome ");
            case OPERA -> System.out.println("Opera");
            case SAFARI -> System.out.println("Safari");
            case FIREFOX -> System.out.println("Firefox");
            case CHROME_HEADLESS -> System.out.println("Chrome headless");
            case FIREFOX_HEADLESS -> System.out.println("Firefox headless");
            default -> throw new IllegalArgumentException("Invalid browser type %s "
                    .formatted(browserTypes.browserName));
        }

        BrowserTypes[] allSupportedBrowsers = BrowserTypes.values();

        for (BrowserTypes browser : allSupportedBrowsers) {
            System.out.println(browser.browserName);
        }

    }
}
