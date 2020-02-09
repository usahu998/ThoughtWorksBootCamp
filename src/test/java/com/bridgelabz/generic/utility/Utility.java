package com.bridgelabz.generic.utility;

import com.bridgelabz.generic.generic.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Utility extends BaseTest {
    public void takeScreenshot(WebDriver driver) throws IOException {
        Date date = new Date();
        String date1 = date.toString();
        System.out.println(date1);
        String date2 = date1.replaceAll(":", "_");
        System.out.println(date2);
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("/home/admin1/FaceBookTestWithSelenium/src/test/java/com/bridgelabz/facebook/Screenshot/" + date2 + "__actiTIMELoginPage.png");
        FileUtils.copyFile(srcFile,destFile);
    }


}
