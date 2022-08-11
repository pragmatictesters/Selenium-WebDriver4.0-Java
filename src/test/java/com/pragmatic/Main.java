package com.pragmatic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Properties props = new Properties();
        try {
            String workingDirectory = System.getProperty("user.dir");
            props.load(new FileInputStream(String.format("%s/src/test/resources/hrm.properties", workingDirectory)));
            System.out.println( props.getProperty("browser.type"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}