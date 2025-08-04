package tests;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AppointmentPage;
import pages.HomePage;
import pages.LoginPage;
import utils.LoggerUtil;

public class BookAppointmentTest extends BaseTest {

    private Logger logger = LoggerUtil.getLogger(this.getClass());

    @Test
    public void testBookAppointmentFlow() {
        logger.info("Starting test: Book Appointment");

        HomePage homePage = new HomePage(driver);
        homePage.clickMakeAppointment();
        logger.info("Clicked on 'Make Appointment'");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("John Doe", "ThisIsNotAPassword");
        logger.info("Logged in successfully");

        // Assertion: Page should now be on appointment form
        String currentUrl = driver.getCurrentUrl();
        logger.info("Current URL after login: " + currentUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue(currentUrl.contains("#appointment"), "User is not on the appointment page after login");
        
        AppointmentPage appointmentPage = new AppointmentPage(driver);
        appointmentPage.bookAppointment("25/12/2025", "Automated booking test");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(driver.getTitle().contains("CURA Healthcare Service"), "Appointment not confirmed");
        
        
    }
}
