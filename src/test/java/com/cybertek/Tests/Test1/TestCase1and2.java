package com.cybertek.Tests.Test1;

import com.cybertek.utilities.TestBase;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestCase1and2 extends TestBase {
    WebDriver driver = null;

    @BeforeSuite
    public void beforeSuit() {
        System.out.println("This is before suit annotation...");

    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("This is before test annotation for Test-1...");

    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("This is before class annotation for Test-1...");
    }

    @BeforeMethod
    @Parameters({"browser"})
    public void beforeMethod(String browser) {
        driver = WebDriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Parameters({"URL"})
    @Test(dependsOnMethods = "TestCase2", groups = {"smoke"})
    public void TestCase1(String URL) throws InterruptedException {
        driver.get(URL);
        driver.findElement(By.xpath("//a[text()=\"Registration Form\"]")).click();
        driver.findElement(By.cssSelector("input[name=\"birthday\"]")).sendKeys("wrong_dob");
        WebElement message = driver.findElement(By.xpath("//small[@data-bv-validator=\"date\"]"));
        Assert.assertTrue(message.isDisplayed());
    }

    @Parameters({"URL"})
    @Test(priority = 1)
    public void TestCase2(String URL) throws InterruptedException {
        driver.get(URL);
        driver.findElement(By.xpath("//a[text()=\"Registration Form\"]")).click();
        WebElement box1 = driver.findElement(By.xpath("//label[@for=\"inlineCheckbox1\"]"));
        Assert.assertTrue(box1.isDisplayed(), "C++ is not displayed");
        WebElement box2 = driver.findElement(By.xpath("//label[@for=\"inlineCheckbox2\"]"));
        Assert.assertTrue(box2.isDisplayed(), "Java is not displayed");
        WebElement box3 = driver.findElement(By.xpath("//label[@for=\"inlineCheckbox3\"]"));
        Assert.assertTrue(box3.isDisplayed(), "JavaScript is not displayed");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

}
