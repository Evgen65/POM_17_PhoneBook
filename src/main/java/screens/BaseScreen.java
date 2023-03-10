package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import models.Contact;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseScreen {

    AppiumDriver<MobileElement> driver;

    public BaseScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void type(MobileElement element, String text) {
        if (text == null) return;
        element.click();
        element.clear();
        element.sendKeys(text);
        driver.hideKeyboard();
    }


    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitElement(MobileElement element, int time) {
        new WebDriverWait(driver, time).until(
                ExpectedConditions.visibilityOf(element)
        );
    }


    public boolean shouldHave(MobileElement element, String text, int time) {
        return new WebDriverWait(driver, time).until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public boolean isErrorMessageContainsText(String text) {
        boolean res = false;
        Alert alert = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
        res = alert.getText().contains(text);
        alert.accept();
       driver.navigate().back();
        return res;
    }

    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            driver.switchTo().alert();
            alert.accept();
            return true;
        }
    }
    public boolean isDisplayedWithExp(MobileElement element,int time){
        try {
            waitElement(element, time);
            return element.isDisplayed();
        }catch (Exception ex){
            return false;
        }
    }


}

