package com.rootcode.sauce.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {

    static Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("/Users/admin/Documents/training/cucumber/ptl-selenium/src/test/resources/sauce.properties")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getBaseURL() {
        return properties.getProperty("base.url");
    }
}
