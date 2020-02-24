package com.cybertek.Tests.Test2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase6 {
    WebDriver driver=null;

    @Parameters({"browser"})
    @BeforeMethod
    public void beforeMethod(String browser){
        driver= WebDriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Parameters({"URL"})
    @Test(enabled = false)
    public void TestCase6(String URL) throws InterruptedException {
        driver.get(URL);
        driver.findElement(By.xpath("//a[@href=\"/upload\"]")).click();
        driver.findElement(By.id("file-upload")).sendKeys("/Users/yusufkucukvatan/Desktop/TestNG_Annotations.png");
        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(1000);
        String expected="File Uploaded!";
        String actual=driver.findElement(By.xpath("//h3[text()='File Uploaded!']")).getText();
        Assert.assertTrue(actual.equals(expected), "Subjects are not the same...");
        String expected2="TestNG_Annotations.png";
        String actual2=driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertTrue(actual2.equals(expected2), "File names are not the same...");

    }
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

}
