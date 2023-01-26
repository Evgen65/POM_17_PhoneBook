import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;
import screens.SplashScreen;

public class LoginTest extends AppiumConfig {
    @Test
    public void loginSuccess() {
       boolean res= new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .fillEmail("abcd@mail.com")
                .fillPassword("Abcd1234$")
                .submitLogin()
                .isContactListActivityPresent()
        ;
        Assert.assertTrue(res);

    }
    @Test
    public void loginSuccessModel() {
        boolean res = new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .login(Auth.builder().email("abcd@mail.com").password("Abcd1234$").build())
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

