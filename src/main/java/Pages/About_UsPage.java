package Pages;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Assertions;

public class About_UsPage extends Base_Page{
    private static final org.apache.logging.log4j.Logger Logger = LogManager.getLogger(About_UsPage.class);
    private static final String AboutUS_PAGE = "http://167.99.178.249:3000/about";
    public static void NavigateToAbout_UsPage() {
        LoginRegister_Page.NavigateToHome_Page();
        findElementByCSS_selector("[name='About Us']").click();
        Assertions.assertTrue(Base_Page.Compare_URL(AboutUS_PAGE));
        Logger.info("About_UsPage was opened");
        Base_Page.takeScreenshot("//img[@src='/img/about.jpg']");


    }

}
