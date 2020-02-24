package com.cybertek.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println(context.getName()+": We are at the beginning of the test. Here we gooooo...");

    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getName()+": Starting Test Case...");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getName()+": Test Case is successful...");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //Screenshots
        //Response if aPI is failed
        System.out.println(result.getName()+": Oooopppsss. Test Case is failed...");

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getName()+": This Test Case skipped!!!");

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println(result.getName()+": This Test Case failed with Time Out!!!");

    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println(context.getName()+": Test is completed. Astalavista...");
    }


}
