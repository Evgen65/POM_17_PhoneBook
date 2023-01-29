package contacts;

import config.AppiumConfig;
import models.Contact;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.ContactListScreen;
import screens.EditContactScreen;
import screens.SplashScreen;

public class EditContactText extends AppiumConfig {
    @BeforeClass
    public void preCondition() {
        new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .fillEmail("abcd@mail.com")
                .fillPassword("Abcd1234$")
                .submitLogin();
    }

    @Test
    public void EditOneContactPositive() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        Contact contact = Contact.builder()
                .name("Jack")
                .lastName("Positive")
                .email("name1" + i + "@mail.com")
                .phone("1234" + i + "78910")
                .address("Tel Aviv")
                .description("Add   Positive")
                .build();
        new ContactListScreen(driver).getContactBefore()
                .openEditForm();
        new EditContactScreen(driver)
                .editData(contact)
                .submitEditContact();
        Assert.assertTrue(new ContactListScreen(driver).getContactAfter()
                .isContactEdited(contact));
        System.out.println();
    }
}
