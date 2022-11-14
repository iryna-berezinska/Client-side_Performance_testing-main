import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.ComputersPage;
import pages.DesktopsPage;
import pages.Homepage;
import util.Constants;
import util.WebDriverHolder;

public class SetUpTests {

    private WebDriver driver;

    @BeforeClass
    protected void setUpBrowser() {
        WebDriverManager.chromedriver().setup();
        Constants.SCENARIO_NAME = this.getClass().getSimpleName();
        WebDriverHolder.setDriver(Constants.BROWSER_FACTORY.startBrowser(Constants.BROWSER_NAME, driver));
        WebDriverHolder.getDriver().get("https://demo.nopcommerce.com/");
    }

    @BeforeMethod
    protected void setUp() {
       Constants.HOMEPAGE = new Homepage();
       Constants.COMPUTERS_PAGE = new ComputersPage();
       Constants.DESKTOPS_PAGE = new DesktopsPage();

    }

    @AfterClass
    protected void teardown() {
        if (WebDriverHolder.getDriver() != null) {
            WebDriverHolder.getDriver().quit();
        }
    }

}
