package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import util.WebDriverHolder;

import java.util.List;

public class DesktopsPage extends BasePage{

    public DesktopsPage() { super(); }

    @FindBy(xpath = "//h2[@class=\"product-title\"]")
    private List<WebElement> desktopProductInfoList;

    @FindBy(xpath = "//button[@class=\"button-1 add-to-cart-button\"]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@class=\"product-name\"]/h1")
    private WebElement productName;

    private final String searchWord = "desktops";

    public DesktopsPage openDesktopsPage() {
        desktopsTitle.click();
        wait.until(ExpectedConditions.elementToBeClickable(desktopProductInfoList.get(1)));
        waitUntilPageIsFullyLoaded(wait);
        Assert.assertTrue(WebDriverHolder.getDriver().getCurrentUrl().contains(searchWord));
        perfNavigationTiming.writeToInflux("DesktopsPage");
        System.out.println("Desktops page is loaded");
        return this;
    }

    public DesktopsPage openSecondDesktop() {
        String secondDesktopInTheListName = desktopProductInfoList.get(1).getText();
        desktopProductInfoList.get(1).click();
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        Assert.assertTrue(productName.getText().contains(secondDesktopInTheListName));
        waitUntilPageIsFullyLoaded(wait);
        perfNavigationTiming.writeToInflux("DesktopPage");
        System.out.println("Asserted that desktop we wanted to open and actually opened desktop are the same");
        return this;
    }

}
