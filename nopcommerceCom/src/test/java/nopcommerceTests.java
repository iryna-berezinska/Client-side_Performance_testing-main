import org.testng.annotations.Test;
import util.Constants;

public class nopcommerceTests extends SetUpTests{

    @Test(priority = 1)
    public void openHomepage() {
        Constants.HOMEPAGE.openHomepage();
    }

    @Test(priority = 2)
    public void openComputersPage() {
        Constants.COMPUTERS_PAGE.openComputersPage();
    }

    @Test(priority = 3)
    public void desktopsPageStuff() {
        Constants.DESKTOPS_PAGE.openDesktopsPage()
        .openSecondDesktop();
    }


}
