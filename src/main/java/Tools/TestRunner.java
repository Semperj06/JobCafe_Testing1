package Tools;

import Pages.Base_Page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import java.util.logging.Level;

import java.util.List;

public class TestRunner {
    private static final org.apache.logging.log4j.Logger Logger = LogManager.getLogger(TestRunner.class);
    private static WebDriver webDriver;
    private static Base_Page page;

    @BeforeAll
    public static void setupMain() {
        page = new Base_Page();
        webDriver = WebDriverFactory.getWebDriver();
        page.setWebDriver(webDriver);
    }

    @AfterAll
    public static void CloseDriver(){
        WebDriverFactory.closeDriver();
        webDriver = null;
    }

    @Test
    public static void LogsTest(){
        LogEntries entries = webDriver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs = entries.getAll();
        for(LogEntry e: logs){
            Logger.error("***Message" + e.getMessage());
            Logger.error("***Message" + e.getLevel());
            Assertions.assertNotEquals(Level.SEVERE, e.getLevel());
            Assertions.assertNotEquals(Level.WARNING, e.getLevel());
        }

    }


}
