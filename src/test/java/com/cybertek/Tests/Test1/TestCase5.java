package com.cybertek.Tests.Test1;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase5 {
    WebDriver driver=null;

    @Parameters({"browser"})
    @BeforeMethod
    public void beforeTestCase5(String browser){
        driver= WebDriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Parameters({"URL","lastName","username","email","password","phone", "birthday"})
    @Test(timeOut = 1000000)
    public void TestCase5(String URL, String lastName, String username, String email, String password, String phone, String birthday ) throws InterruptedException {
        driver.get(URL);
        Faker faker=new Faker();
        driver.findElement(By.xpath("//a[text()=\"Registration Form\"]")).click();
        driver.findElement(By.xpath("//input[@name=\"firstname\"]")).sendKeys(faker.name().firstName());
        driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//input[@name=\"phone\"]")).sendKeys(phone);
        driver.findElement(By.xpath("//input[@value=\"male\"]")).click();
        driver.findElement(By.xpath("//input[@name=\"birthday\"]")).sendKeys(birthday);
        WebElement department=driver.findElement(By.xpath("//select[@name=\"department\"]"));
        Select s1=new Select(department);
        s1.selectByIndex(1);
        WebElement jobTitle=driver.findElement(By.xpath("//select[@name=\"job_title\"]"));
        Select s2=new Select(jobTitle);
        s2.selectByVisibleText("SDET");
        driver.findElement(By.id("inlineCheckbox2")).click();
        driver.findElement(By.id("wooden_spoon")).click();
        WebElement message= driver.findElement(By.xpath("//div[@class=\"alert alert-success\"]/p"));
        String expected="You've successfully completed registration!";
        String actual=message.getText();
        Assert.assertEquals(actual, expected, actual+" is displayed instead of "+expected);
    }
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

}
