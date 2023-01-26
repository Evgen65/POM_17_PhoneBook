package registration;

import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.ContactListScreen;
import screens.SplashScreen;

public class RegistrationPositiveTests extends AppiumConfig {
    @Test
    public void registrationSuccess() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        boolean res = new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .fillEmail("abcd" + i + "@mail.com")
                .fillPassword("Abcd1234$")
                .submitRegistration()
                .isContactListActivityPresent();
        Assert.assertTrue(res);

    }
    @Test
    public void registrationSuccessModels() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        boolean res = new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .registration(Auth.builder().email("abcd" + i + "@mail.com").password("Abcd1234$").build())
                .isContactListActivityPresent();
        Assert.assertTrue(res);

    }
    @AfterMethod
    public void postCondition() {
        if (new ContactListScreen(driver).isContactListActivityPresent()) {
            new ContactListScreen(driver).logout();
            new SplashScreen(driver);
        }
   }
}
