package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class Homepage extends BasePage{

    public Homepage() { super(); }

    @FindBy(xpath = "//input[@class=\"search-box-text ui-autocomplete-input\"]")
    private WebElement searchInput;

    public Homepage openHomepage() {
        wait.until(ExpectedConditions.elementToBeClickable(computersButton));
        Assert.assertTrue(searchInput.isDisplayed());
        perfNavigationTiming.writeToInflux("Homepage");
        System.out.println("Homepage is loaded");
        return this;
    }

}
