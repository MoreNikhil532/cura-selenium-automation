package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.logging.log4j.Logger; // ✅ Correct import

import utils.LoggerUtil;
import utils.WebDriverFactory;

public class BaseTest {
    protected WebDriver driver;
    protected Logger logger = LoggerUtil.getLogger(this.getClass());

    @BeforeMethod
    public void setUp() {
        logger.info("Starting test setup...");
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        logger.info("Navigated to CURA Healthcare site");
    }

    @AfterMethod
    public void tearDown() {
        logger.info("Tearing down WebDriver");
        WebDriverFactory.quitDriver();
    }
}
