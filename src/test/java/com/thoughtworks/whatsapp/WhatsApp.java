package com.thoughtworks.whatsapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import static com.bridgelabz.generic.generic.IAutoConstant.CHROME_KEY;
import static com.bridgelabz.generic.generic.IAutoConstant.CHROME_VALUE;

public class WhatsApp {
    public static void main(String[] args) throws AWTException, InterruptedException {
        System.setProperty(CHROME_KEY, CHROME_VALUE);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://web.whatsapp.com/");
        Thread.sleep(10000);

        Robot robot = new Robot();
        robot.mouseMove(250, 330);
        Thread.sleep(5000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        for (int i = 0; i < 5; i++) {
            driver.findElement(By.xpath("//div[@class='_3u328 copyable-text selectable-text']"))
                    .sendKeys("Hii");
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }
        Thread.sleep(5000);
        driver.close();
    }
}
