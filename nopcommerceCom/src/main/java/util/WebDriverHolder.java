package util;

import org.openqa.selenium.WebDriver;

import java.util.Optional;

public class WebDriverHolder {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (!Optional.ofNullable(driver).isPresent()) {
            Constants.BROWSER_FACTORY.startBrowser(Constants.BROWSER_NAME, driver);
            return driver;
        } else {
            return driver;
        }
    }

    public static void setDriver(WebDriver driver) {
    WebDriverHolder.driver = driver;
    }


}
