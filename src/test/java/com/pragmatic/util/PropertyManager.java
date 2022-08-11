package com.pragmatic.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    private static Properties props = new Properties();

    static {

        String workingDirectory = System.getProperty("user.dir");
        try {
            props.load(new FileInputStream(String.format("%s/src/test/resources/hrm.properties", workingDirectory)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static String getProperty(String propertyName) {
        return props.getProperty(propertyName);
    }
}
