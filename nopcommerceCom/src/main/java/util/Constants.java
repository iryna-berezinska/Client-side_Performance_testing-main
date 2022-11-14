package util;

import pages.ComputersPage;
import pages.DesktopsPage;
import pages.Homepage;

public class Constants {

    public final static BrowserFactory BROWSER_FACTORY = new BrowserFactory();
    public final static String BROWSER_NAME = "Chrome";
    public static String SCENARIO_NAME;
    public static Homepage HOMEPAGE;
    public static ComputersPage COMPUTERS_PAGE;
    public static DesktopsPage DESKTOPS_PAGE;


    public final static String DATABASE_URL = "http://localhost:8086";
    public final static String DATABASE_NAME = "nc";
    public final static String BUILD_ID = "1";
    public final static String PROJECT_NAME = "nopcommerce";
    public final static String ENV_NAME = "Test";

}
