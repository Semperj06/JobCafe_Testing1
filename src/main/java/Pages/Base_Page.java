package Pages;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Objects;
import java.util.logging.Logger;

public class Base_Page {
    private static int screenshotCount = 0;
    private static final org.apache.logging.log4j.Logger Logger = LogManager.getLogger(Base_Page.class);
    protected static WebDriver webDriver;
    protected static WebDriverWait wait;

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
    }

    protected static void clickOnElement(String xpath) {
        findElementByXpath(xpath).click();
    }


    protected static boolean elementExists(String xpath) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            webDriver.findElement(By.xpath(xpath));
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    protected static boolean Compare_URL(String Expected_url) {
        if (Objects.equals(Expected_url, webDriver.getCurrentUrl())) {
            return true;
        } else {
            return false;
        }

    }

    protected static WebElement findElementByXpath(String xpath) {
        WebElement element;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        element = webDriver.findElement(By.xpath(xpath));
        return element;
    }

    protected static WebElement findElementByCSS_selector(String xpath) {
        WebElement element;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(xpath)));
        element = webDriver.findElement(By.cssSelector(xpath));
        return element;
    }


    protected static void sendKeys(String xpath, String keys) {
        WebElement element = findElementByXpath(xpath);
        clickOnElement(xpath);
        element.sendKeys(keys);

    }

    protected static void pause(int second) {
        try {
            Thread.sleep(second);
        } catch (Exception err) {
            Logger.error("Something went wrong");
        }
    }

    protected static void takeScreenshot(String xpath) {
        if (xpath.equals("//")) {
            try {
                screenshotCount++;
                File file = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(file, new File("screenshots/logo" + screenshotCount + ".png"));
                Logger.info("Screenshot created");
            } catch (IOException e) {
                Logger.error("Screenshot failed");
            }
        }
        else if (elementExists(xpath)) {
                try {
                    screenshotCount++;
                    File file = findElementByXpath(xpath).getScreenshotAs(OutputType.FILE);
                    FileUtils.copyFile(file, new File("screenshots/logo" + screenshotCount + ".png"));
                    Logger.info("Screenshot created");
                } catch (IOException e) {
                    Logger.error("Screenshot failed");
                }

            } else {
                Logger.error("Screenshot failed");

            }
        }
        protected static void scrollTyElem (String xpath){

            if (elementExists(xpath)) {
                WebElement element = findElementByXpath(xpath);
                ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
                Logger.info("Page scroll to" + xpath);
            } else {
                Logger.error("Something is wrong");
            }
        }
        protected static void scrollByPixel ( int pixels){
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            js.executeScript("window.scrollBy(0," + pixels + ")");
        }


    }
