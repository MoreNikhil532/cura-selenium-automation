package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    // Locators
    private By makeAppointmentButton = By.id("btn-make-appointment");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void clickMakeAppointment() {
        driver.findElement(makeAppointmentButton).click();
    }
}
