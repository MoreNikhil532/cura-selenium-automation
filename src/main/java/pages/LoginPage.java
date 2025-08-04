package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.LoggerUtil;
import org.apache.logging.log4j.Logger;

public class LoginPage {
    private WebDriver driver;
    private Logger logger = LoggerUtil.getLogger(this.getClass());

    // Locators
    private By usernameInput = By.id("txt-username");
    private By passwordInput = By.id("txt-password");
    private By loginButton = By.id("btn-login");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void enterUsername(String username) {
        logger.info("Entering username: " + username);
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        logger.info("Entering password");
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        logger.info("Clicking Login button");
        driver.findElement(loginButton).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
