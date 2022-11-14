package pages;

import navigationtiming.PerfNavigationTiming;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.WebDriverHolder;

public class BasePage {

    protected WebDriverWait wait;

    public BasePage() {
        wait = new WebDriverWait(WebDriverHolder.getDriver(), 50);
        PageFactory.initElements(WebDriverHolder.getDriver(), this);
    }

    protected PerfNavigationTiming perfNavigationTiming = new PerfNavigationTiming();

    protected void waitUntilPageIsFullyLoaded(WebDriverWait wait) {
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    /* Common locators */
    @FindBy(xpath = "//ul[@class=\"top-menu notmobile\"]//a[@href=\"/computers\"]")
    protected WebElement computersButton;

    @FindBy(xpath = "//h2[@class=\"title\"]//a[@href=\"/desktops\"]")
    protected WebElement desktopsTitle;


}
