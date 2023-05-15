package Pages;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Assertions;


public class LoginRegister_Page extends Base_Page{
    private static final org.apache.logging.log4j.Logger Logger = LogManager.getLogger(LoginRegister_Page.class);
    private static final String HOME_PAGE = "http://167.99.178.249:3000/";
    public static void NavigateToHome_Page() {
        webDriver.get(HOME_PAGE);
        Assertions.assertTrue(Base_Page.Compare_URL(HOME_PAGE));
        Logger.info("Main page was opened");
    }
    public static void VerifyIMGHome_Page() {
        Base_Page.takeScreenshot("//img[@src='/img/site_bg.jpg']");
        Base_Page.scrollTyElem("//img[@src='/img/why-us.jpg']");
        Base_Page.pause(2000);
        Base_Page.takeScreenshot("//img[@src='/img/why-us.jpg']");
        Base_Page.scrollTyElem("//img[@src='/img/features-1.svg']");
        Base_Page.pause(2000);
        Base_Page.takeScreenshot("//img[@src='/img/features-1.svg']");

        Base_Page.scrollTyElem("//img[@src='/img/features-2.svg']");
        Base_Page.pause(2000);
        Base_Page.takeScreenshot("//img[@src='/img/features-2.svg']");

        Base_Page.scrollTyElem("//img[@src='/img/features-3.svg']");
        Base_Page.pause(2000);
        Base_Page.takeScreenshot("//img[@src='/img/features-3.svg']");

        Base_Page.scrollTyElem("//img[@src='/img/features-4.svg']");
        Base_Page.pause(2000);
        Base_Page.takeScreenshot("//img[@src='/img/features-4.svg']");
    }
    public static void NegativeTesting_EditBox(String search, String location){
        pause(4000);
        String search_path = "//input[@placeholder='Search jobs, keywords or company']";
        String location_path = "//input[@placeholder='Location']";
        scrollTyElem(search_path);
        Base_Page.sendKeys(search_path, search);
        Base_Page.sendKeys(location_path, location);
        Base_Page.clickOnElement("//*[normalize-space(text())='Submit']");
        Base_Page.pause(2000);
        Assertions.assertTrue(Base_Page.Compare_URL(HOME_PAGE));

    }

}
