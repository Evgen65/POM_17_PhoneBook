package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class AddNewContactScreen extends BaseScreen {
    @FindBy(xpath = "//*[@resource-id = 'com.sheygam.contactapp:id/inputName']")
    MobileElement typeName;
    @FindBy(xpath = "//*[@resource-id = 'com.sheygam.contactapp:id/inputLastName']")
    MobileElement typeLastName;
    @FindBy(xpath = "//*[@resource-id = 'com.sheygam.contactapp:id/inputEmail']")
    MobileElement typeEmail;
    @FindBy(xpath = "//*[@resource-id = 'com.sheygam.contactapp:id/inputPhone']")
    MobileElement typePhone;
    @FindBy(xpath = "//*[@resource-id = 'com.sheygam.contactapp:id/inputAddress']")
    MobileElement typeAddress;
    @FindBy(xpath = "//*[@resource-id = 'com.sheygam.contactapp:id/inputDesc']")
    MobileElement typeDescription;
    @FindBy(xpath = "//*[@resource-id = 'com.sheygam.contactapp:id/createBtn']")
    MobileElement clickButtonCreate;

    public AddNewContactScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
}
