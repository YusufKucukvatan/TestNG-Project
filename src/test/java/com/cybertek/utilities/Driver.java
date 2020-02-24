package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeSuite;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Driver {
    WebDriver driver=null;

    @BeforeSuite
    public void getDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("/Users/yusufkucukvatan/IdeaProjects/testNGProject/configuration.properties");
        prop.load(fis);
        if (prop.getProperty("browser").contains("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(prop.getProperty("browser").contains("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }


        //driver.get(prop.getProperty("url"));
    }

}
