package com.cybertek.Tests.Test1;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase3and4 {
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
    @Test(priority = 2, groups = {"smoke"})
    public void TestCase3(String URL) throws InterruptedException {
        driver.get(URL);
        driver.findElement(By.xpath("//a[text()=\"Registration Form\"]")).click();
        driver.findElement(By.xpath("//input[@name=\"firstname\"]")).sendKeys("a");
        WebElement message= driver.findElement(By.xpath("//small[@data-bv-validator=\"stringLength\"][@data-bv-for=\"firstname\"]"));
        String expected="first name must be more than 2 and less than 64 characters long";
        String actual=message.getText();
        Assert.assertTrue(actual.equals(expected), actual+" is displayed insread of "+expected);
    }
    @Parameters({"URL"})
    @Test(priority = 1, timeOut = 20_000)
    public void TestCase4(String URL) throws InterruptedException {
        driver.get(URL);
        driver.findElement(By.xpath("//a[text()=\"Registration Form\"]")).click();
        driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("b");
        WebElement message= driver.findElement(By.xpath("//small[@data-bv-validator=\"stringLength\"][@data-bv-for=\"lastname\"]"));
        String expected="The last name must be more than 2 and less than 64 characters long";
        String actual=message.getText();
        Assert.assertTrue(actual.equals(expected), actual+" is displayed insread of "+expected);
    }
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

}
