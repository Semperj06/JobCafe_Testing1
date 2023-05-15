package Pages;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Assertions;

public class PostJob_Page extends Base_Page{
    private static final org.apache.logging.log4j.Logger Logger = LogManager.getLogger(PostJob_Page.class);
    private static final String PostJob_PAGE = "http://167.99.178.249:3000/contact-us";
    public static void NavigateToPostJob_Page() {
        String PostJob_xpath = "//a[@id='0']";
        LoginRegister_Page.NavigateToHome_Page();
        Base_Page.clickOnElement(PostJob_xpath);
        Assertions.assertTrue(Base_Page.Compare_URL(PostJob_PAGE));
        Logger.info("PostJob_PAGE was opened");
    }
}
