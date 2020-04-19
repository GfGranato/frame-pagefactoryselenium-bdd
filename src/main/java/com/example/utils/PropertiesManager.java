package com.example.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {

    Properties prop = new Properties();
    File file = new File("src/main/resources/properties/com.example");

    public String getProp(String valor) {
        try {
            if (System.getProperty("env") == null) {
                prop.load(new FileInputStream( file.getAbsolutePath() + "/config.properties"));
            } else {
                prop.load(new FileInputStream(file.getCanonicalPath() + "/" + System.getProperty("env")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(valor);
    }
}