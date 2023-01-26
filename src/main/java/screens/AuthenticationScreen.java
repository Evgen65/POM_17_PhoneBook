package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Auth;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthenticationScreen extends BaseScreen {

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputEmail']")
    MobileElement editTextEmail;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputPassword']")
    MobileElement editTextPassword;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/regBtn']")
    MobileElement registrationButton;
    //    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/loginBtn']")
//    MobileElement loginButton;
    @FindBy(id = "com.sheygam.contactapp:id/loginBtn")
    MobileElement loginButton;

    @FindBy(how = How.ID, using = "android:id/message")
    MobileElement alertButton;
    @FindBy(how = How.ID, using = "android:id/message")
    MobileElement errorDescription;
    @FindBy(how = How.ID, using = "android:id/button1")
    MobileElement widgetButton;


    public AuthenticationScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public AuthenticationScreen closeTheAlert() {
        widgetButton.click();
        return this;
    }

    public boolean isAlertUserFormat() {
        return shouldHave(alertButton, "username=must be a well-formed email address", 5000);
    }


    public AuthenticationScreen fillEmail(String email) {
        waitElement(editTextEmail, 5);
        type(editTextEmail, email);
        return this;

    }

    public AuthenticationScreen fillPassword(String email) {
        waitElement(editTextPassword, 5);
        type(editTextPassword, email);
        return this;

    }

    public ContactListScreen submitLogin() {
        loginButton.click();
        return new ContactListScreen(driver);
    }

    public ContactListScreen submitRegistration() {
        registrationButton.click();
        return new ContactListScreen(driver);
    }

    public AuthenticationScreen submitNegativeRegistration() {
        registrationButton.click();
        return new AuthenticationScreen(driver);
    }

    public ContactListScreen login(Auth auth) {
        waitElement(editTextEmail, 5);
        type(editTextEmail, auth.getEmail());
        type(editTextPassword, auth.getPassword());
        loginButton.click();
        return new ContactListScreen(driver);
    }

    public ContactListScreen registration(Auth auth) {
        waitElement(editTextEmail, 5);
        type(editTextEmail, auth.getEmail());
        type(editTextPassword, auth.getPassword());
        registrationButton.click();
        return new ContactListScreen(driver);
    }

    public String alertScript() {
        return errorDescription.getText();
    }


    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
            return true;
        }
    }

    public boolean isErrorMessageInFormat() {
        Alert alert = new WebDriverWait(driver, 0, 5)
                .until((ExpectedConditions.alertIsPresent()));
        String errorMassage = "User already exists";
        return alert.getText().contains(errorMassage);
    }
}






