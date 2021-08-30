package models.components.authentication;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.pages.LoginPageMethodChaining;
import org.openqa.selenium.By;

public class CredentialForm {
    private AppiumDriver<MobileElement> appiumDriver;
    private final By usernameSelById = MobileBy.AccessibilityId("input-email");
    private final By passwordSelById = MobileBy.AccessibilityId("input-password");

    public CredentialForm(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public MobileElement username() {
        return appiumDriver.findElement(usernameSelById);
    }

    public CredentialForm inputUsername(String usernameText) {
        this.username().sendKeys(usernameText);
        return this;
    }

    public MobileElement password() {
        return appiumDriver.findElement(passwordSelById);
    }


    public CredentialForm inputPassword(String passwordText) {
        this.password().sendKeys(passwordText);
        return this;
    }

}
