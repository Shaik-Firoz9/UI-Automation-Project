package com.maveric.capstone.factory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class DriverFactory {
    private static ChromeDriver chromeDriverExplicitConfig() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mohammads\\SeleniumDriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions  options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setBinary("C:\\Users\\mohammads\\SeleniumDriver\\chrome-win64\\chrome.exe");
        ChromeDriver chromeDriver = new ChromeDriver(options);
        return chromeDriver;
    }
    public static WebDriver getDriver() {
        WebDriver driver =  chromeDriverExplicitConfig();
        return driver ;
    }
}


