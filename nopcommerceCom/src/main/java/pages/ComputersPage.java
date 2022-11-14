package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import util.Constants;
import util.WebDriverHolder;


public class ComputersPage extends BasePage{

    public ComputersPage() { super(); }

    private final String searchWord = "computers";

    public ComputersPage openComputersPage() {
        computersButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(desktopsTitle));
        waitUntilPageIsFullyLoaded(wait);
        Assert.assertTrue(WebDriverHolder.getDriver().getCurrentUrl().contains(searchWord));
        perfNavigationTiming.writeToInflux("ComputersPage");
        System.out.println("Computers page is loaded");
        return this;
    }


}
