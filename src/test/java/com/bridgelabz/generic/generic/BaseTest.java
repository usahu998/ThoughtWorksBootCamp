package com.bridgelabz.generic.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static com.bridgelabz.generic.generic.IAutoConstant.*;

public class BaseTest {
    public WebDriver driver;

    static {
        System.setProperty(GECKO_KEY, GECKO_VALUE);
        System.setProperty(CHROME_KEY, CHROME_VALUE);
    }

    @BeforeTest
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        String url = Library.getProperty(CONFIG_PATH, "URL");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(url);
        String ITO = Library.getProperty(CONFIG_PATH, "ImplicitTimeOut");
        int timeoutPeriod = Integer.parseInt(ITO);
        driver.manage().timeouts().implicitlyWait(timeoutPeriod, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void close() {
            driver.quit();
        }
    }

