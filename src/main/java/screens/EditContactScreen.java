package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Contact;
import org.openqa.selenium.support.FindBy;

public class EditContactScreen extends BaseScreen{

    public EditContactScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(id = "com.sheygam.contactapp:id/inputName")
    MobileElement inputName;
    @FindBy(id = "com.sheygam.contactapp:id/inputLastName")
    MobileElement inputLastName;
    @FindBy(id = "com.sheygam.contactapp:id/inputEmail")
    MobileElement inputEmail;
    @FindBy(id = "com.sheygam.contactapp:id/inputPhone")
    MobileElement inputPhone;
    @FindBy(id = "com.sheygam.contactapp:id/inputAddress")
    MobileElement inputAddress;
    @FindBy(id = "com.sheygam.contactapp:id/inputDesc")
    MobileElement inputDescription;
    @FindBy(id = "com.sheygam.contactapp:id/updateBtn")
    MobileElement buttonUpdate;

    public EditContactScreen editData(Contact contact){
        waitElement(buttonUpdate, 5);
        type(inputName, contact.getName());
        type(inputLastName, contact.getLastName());
        type(inputEmail, contact.getEmail());
        type(inputPhone, contact.getPhone());
        type(inputAddress, contact.getAddress());
        type(inputDescription, contact.getDescription());
        return this;
    }

    public EditContactScreen submitEditContact() {
        buttonUpdate.click();
        return this;
    }


}
