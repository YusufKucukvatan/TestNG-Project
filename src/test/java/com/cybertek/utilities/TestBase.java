package com.cybertek.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    WebDriver driver=null;
    @BeforeClass
    public void logIn() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("/Users/yusufkucukvatan/IdeaProjects/testNGProject/configuration.properties");
        prop.load(fis);
        System.out.println(prop.getProperty("username"));
        System.out.println(prop.getProperty("password"));
        System.out.println(prop.getProperty("url"));
    }
}

