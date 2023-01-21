package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class LoginRegistrationScreen extends BaseScreen {

    @FindBy(xpath = "//*[@resource-id = 'com.sheygam.contactapp:id/inputEmail']")
    MobileElement typeEmail;
    @FindBy(xpath = "//*[@resource-id = 'com.sheygam.contactapp:id/inputPassword']")
    MobileElement typePass;
    @FindBy(xpath = "//*[@resource-id = 'com.sheygam.contactapp:id/regBtn']")
    MobileElement clickRegistration;
    @FindBy(xpath = "//*[@resource-id = 'com.sheygam.contactapp:id/loginBtn']")
    MobileElement clickLogin;

    public LoginRegistrationScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public String getCurrentEmail() {
        return typeEmail.getText();

    }
}
