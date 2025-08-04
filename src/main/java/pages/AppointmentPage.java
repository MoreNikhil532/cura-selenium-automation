package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.LoggerUtil;
import org.apache.logging.log4j.Logger;

public class AppointmentPage {
    private WebDriver driver;
    private Logger logger = LoggerUtil.getLogger(this.getClass());

    // Locators
    private By facilityDropdown = By.id("combo_facility");
    private By readmissionCheckbox = By.id("chk_hospotal_readmission");
    private By medicaidRadio = By.id("radio_program_medicaid");
    private By dateInput = By.id("txt_visit_date");
    private By commentInput = By.id("txt_comment");
    private By bookButton = By.id("btn-book-appointment");

    // Constructor
    public AppointmentPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void bookAppointment(String date, String comment) {
        logger.info("Filling out appointment form");
        Select facility = new Select(driver.findElement(facilityDropdown));
        facility.selectByVisibleText("Hongkong CURA Healthcare Center");

        driver.findElement(readmissionCheckbox).click();
        driver.findElement(medicaidRadio).click();
        driver.findElement(dateInput).sendKeys(date);
        driver.findElement(commentInput).sendKeys(comment);
        driver.findElement(bookButton).click();
        logger.info("Clicked on Book Appointment");
    }
}
