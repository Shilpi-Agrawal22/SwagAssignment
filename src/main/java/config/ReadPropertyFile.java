package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ReadPropertyFile {



    public String readProp(String property) {
        Properties prop = new Properties();
        FileInputStream ip = null;
        try {
            ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/config/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop.getProperty(property);
    }

    public String readTestData(String property) {
        Properties prop = new Properties();
        FileInputStream propFile = null;
        try {
            propFile = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/config/testData.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(propFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop.getProperty(property);
    }
}
