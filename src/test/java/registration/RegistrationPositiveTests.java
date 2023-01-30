package registration;

import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;
import screens.SplashScreen;

public class RegistrationPositiveTests extends AppiumConfig {
    @Test
    public void registrationSuccess() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        Assert.assertTrue(new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .fillEmail("abcd" + i + "@mail.com")
                .fillPassword("Abcd1234$")
                .submitRegistration()
                .isContactListActivityPresent());

    }

    @Test
    public void registrationSuccessModels() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        boolean res = new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .registration(Auth.builder().email("abcd" + i + "@mail.com").password("Abcd1234$").build())
                .isContactListActivityPresent();

    }

    @Test
    public void negativeRegEmailFormat() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        Assert.assertTrue(new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .fillEmail("wrongmail.com")
                .fillPassword("Abcd1234$")
                .submitNegativeRegistration()
                .isErrorMessageContainsText("username=must be a well-formed email address"));

    }

    @AfterMethod
    public void postCondition() {
        new ContactListScreen(driver).moreOption().logout();
        new SplashScreen(driver);

    }
}
