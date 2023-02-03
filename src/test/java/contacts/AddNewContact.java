package contacts;

import config.AppiumConfig;
import models.Contact;
import org.testng.Assert;
import org.testng.annotations.*;
import screens.AddNewContactScreen;
import screens.AuthenticationScreen;
import screens.ContactListScreen;
import screens.SplashScreen;

import java.util.Random;

public class AddNewContact extends AppiumConfig {
    @BeforeMethod
    public void preCondition() {
        new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .fillEmail("abcd@mail.com")
                .fillPassword("Abcd1234$")
                .submitLogin();
    }

    @Test(invocationCount = 1)
    public void addOneContactPositive() {
        int i = new Random().nextInt(1000) + 1000;
        Contact contact = Contact.builder()
                .name("Add_" + i)
                .lastName("Positive")
                .email("add_" + i + "@mail.com")
                .phone("123456" + i)
                .address("Haifa")
                .description("Add " + i + " New Positive")
                .build();
        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContact()
                .isContactAdded(contact);
    }

    @Test
    public void addOneContactNegativeEmptyPhone() {
        Contact contact = Contact.builder()
                .name("EmptyPhone")
                .lastName("Negative")
                .email("emptyPhone@mail.com")
                .phone("")
                .address("Haifa")
                .description("Add   Negative")
                .build();

        Assert.assertTrue(
                new ContactListScreen(driver)
                        .openContactForm()
                        .fillContactForm(contact)
                        .submitContactNegative()
                        .isErrorMessageContainsText("Error"));
    }

    @AfterMethod
    public void postCondition() {
        new ContactListScreen(driver).moreOption().logout();
        new SplashScreen(driver);
    }


}