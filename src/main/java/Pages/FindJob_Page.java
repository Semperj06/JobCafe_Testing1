package Pages;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

public class FindJob_Page extends Base_Page {
    private static final org.apache.logging.log4j.Logger Logger = LogManager.getLogger(FindJob_Page.class);
    private static final String FINDJOB_URL = "http://167.99.178.249:3000/job-page";
    private static final String SEARCH_XPATH = "//button[@type='submit' and text()='search']";
    private static final String RESET_XPATH = "//button[@type='submit' and text()='reset']";

    public static void NavigateToJOB_Page() {
        clickOnElement("//a[@id='3']");
        Assertions.assertTrue(Base_Page.Compare_URL(FINDJOB_URL));
        Logger.info("Find Job page was opened");
    }

    public static void Position_EditBox(String position) {
        String xpath_position = "//input[@name='position']";
        sendKeys(xpath_position, position);
        clickOnElement(SEARCH_XPATH);
        pause(2000);
        takeScreenshot("//");
        scrollTyElem("//button[@aria-label='Go to page 2' and text()='2']");
        pause(1000);
        clickOnElement("//button[@aria-label='Go to page 2' and text()='2']");
        pause(1000);
        takeScreenshot("//");
    }

    public static void Location_EditBox(String location) {
        String xpath_location = "//input[@name='location']";
        sendKeys(xpath_location, location);
        clickOnElement(SEARCH_XPATH);
        pause(2000);
        takeScreenshot("//");
        scrollTyElem("//button[@aria-label='Go to page 2' and text()='2']");
        pause(1000);
        clickOnElement("//button[@aria-label='Go to page 2' and text()='2']");
        pause(1000);
        takeScreenshot("//");
    }
    public static void Company_EditBox(String company) {
        String xpath_company = "//input[@name='company']";
        sendKeys(xpath_company, company);
        clickOnElement(SEARCH_XPATH);
        pause(2000);
        takeScreenshot("//");
        scrollTyElem("//button[@aria-label='Go to page 2' and text()='2']");
        pause(1000);
        clickOnElement("//button[@aria-label='Go to page 2' and text()='2']");
        pause(1000);
        takeScreenshot("//");
    }
    public static void FunctionalTesting(String position, String location, String company) {
        String xpath_position = "//input[@name='position']";
        sendKeys(xpath_position, position);
        String xpath_location = "//input[@name='location']";
        sendKeys(xpath_location, location);
        String xpath_company = "//input[@name='company']";
        sendKeys(xpath_company, company);
        clickOnElement(SEARCH_XPATH);
        pause(2000);
        takeScreenshot("//");
        scrollTyElem("//button[@aria-label='Go to page 2' and text()='2']");
        pause(1000);
        clickOnElement("//button[@aria-label='Go to page 2' and text()='2']");
        pause(1000);
        takeScreenshot("//");
    }
    public static void Reset() {
        clickOnElement(RESET_XPATH);
        pause(1000);
        takeScreenshot("//");

    }
}
