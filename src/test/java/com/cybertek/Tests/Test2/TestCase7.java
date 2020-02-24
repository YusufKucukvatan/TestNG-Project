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

public class TestCase7 {
    WebDriver driver=null;

    @Parameters({"browser"})
    @BeforeMethod
    public void beforeMethod(String browser){
        driver= WebDriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);    }

        @Parameters({"URL","URL2","fullName"})
        @Test
    public void TestCase7(String URL,String URL2,String fullName) throws InterruptedException {
        driver.get(URL2);
        String email=driver.findElement(By.id("email")).getText();
        driver.get(URL);
        driver.findElement(By.xpath("//a[text()='Sign Up For Mailing List']")).click();
        driver.findElement(By.xpath("//input[@name=\"full_name\"]")).sendKeys(fullName);
        driver.findElement(By.xpath("//input[@type=\"email\"]")).sendKeys(email);
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        String expected="Thank you for signing up. Click the button below to return to the home page.";
        String actual= driver.findElement(By.xpath("//h3[@name=\"signup_message\"]")).getText();
        Assert.assertTrue(actual.equals(expected), "Sign in message is not true...");
        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(3000);
        driver.get(URL2);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//table[@class=\"table table-hover\"]/tbody/tr[1]")).click();
        String expectedEmailAddress="do-not-reply@practice.cybertekschool.com";
        String actualEmailAddress= driver.findElement(By.id("odesilatel")).getText();
        Assert.assertTrue(actualEmailAddress.equals(expectedEmailAddress), "email addresses are not the same...");
        String expextedSubject="Thanks for subscribing to practice.cybertekschool.com!";
        String actualSubject=driver.findElement(By.id("predmet")).getText();
        Assert.assertTrue(actualSubject.equals(expextedSubject), "Subjects are not the same...");
    }
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}
