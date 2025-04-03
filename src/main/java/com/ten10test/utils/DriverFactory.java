package com.ten10test.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverFactory {

    public static WebDriver driver;
    public static final String url = "https://ten10techtest-dnd6bgfzcqdggver.uksouth-01.azurewebsites.net";

    public static WebDriver newDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        driver.get(url);
        return driver;
    }
}
