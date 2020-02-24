package com.cybertek.packages;

import com.cybertek.utilities.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginPage {
    public void mainPage() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("/Users/yusufkucukvatan/IdeaProjects/testNGProject/configuration.properties");
        prop.load(fis);

    }
}
