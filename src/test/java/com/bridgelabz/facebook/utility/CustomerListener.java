package com.bridgelabz.facebook.utility;

import com.bridgelabz.facebook.generic.BaseTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class CustomerListener extends BaseTest implements ITestListener {



    public void onTestStart(ITestResult result) {
        Utility utility = new Utility();
        try {
            utility.takeScreenshot(driver);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onTestSuccess(ITestResult result) {
        Utility utility = new Utility();
        try {
            utility.takeScreenshot(driver);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Utility utility = new Utility();
        try {
            utility.takeScreenshot(driver);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
