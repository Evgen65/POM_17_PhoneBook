package registration;

import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;
import screens.SplashScreen;

public class RegistrationNegativeTests extends AppiumConfig {
    @Test
    public void negativeRegEmailFormat() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        boolean res = new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .fillEmail("wromgmail.com")
                .fillPassword("Abcd1234$")
                .submitNegativeRegistration()
                .isAlertUserFormat();
        Assert.assertTrue(res);
        new AuthenticationScreen(driver).closeTheAlert();
    }


    @Test
    public void negativeRegPassFormat() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        Assert.assertTrue(new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .fillEmail("abcd" + i + "@mail.com")
                .fillPassword("Abcd1234")
                .submitNegativeRegistration()
                .isErrorMessageContainsText("Error"));
//        String alertScript=new AuthenticationScreen(driver).alertScript();
//        Assert.assertEquals("username=must be a well-formed email address",alertScript);
    }
    @Test
    public void negativeRegExistUser() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .registration(Auth.builder().email("abcd" + i + "@mail.com").password("Abcd1234$").build())
                .isContactListActivityPresent();
        new ContactListScreen(driver).logout();
        Assert.assertTrue(new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .fillEmail("abcd" + i + "@mail.com")
                .fillPassword("Abcd1234$")
                .submitNegativeRegistration()
                .isAlertPresent()
        );
    }
    @AfterMethod
    public void postCondition() {
        new SplashScreen(driver);
    }
}
