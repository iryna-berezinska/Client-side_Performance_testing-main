package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {
    public WebDriver startBrowser(String browserName, WebDriver driver) {
        if ("Chrome".equalsIgnoreCase(browserName)) {
            driver = new ChromeDriver();
        } else if ("Firefox".equalsIgnoreCase(browserName)) {
            driver = new FirefoxDriver();
        }
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    return driver;
    }
}
