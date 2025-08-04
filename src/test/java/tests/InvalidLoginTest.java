package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class InvalidLoginTest extends BaseTest {

    @Test
    public void testInvalidLogin() {
        HomePage homePage = new HomePage(driver);
        homePage.clickMakeAppointment();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("wrongUser", "wrongPass");

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("profile.php#login"), "User should not be logged in with invalid credentials");
    }
}
