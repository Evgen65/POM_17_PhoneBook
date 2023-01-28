package contacts;

import config.AppiumConfig;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.ContactListScreen;
import screens.SplashScreen;

public class RemoveContactsTests extends AppiumConfig {
    @BeforeClass
    public void preCondition(){
        new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .fillEmail("abcd@mail.com")
                .fillPassword("Abcd1234$")
                .submitLogin();
    }

    @Test
    public void removeOneContactPositive(){
        new ContactListScreen(driver).removeOneContact();
    }

}
