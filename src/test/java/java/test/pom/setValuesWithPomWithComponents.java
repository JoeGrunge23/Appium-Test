package test.pom;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.pages.LoginPage;
import models.pages.LoginPageWithComponents;
import utils.AppiumDriveEx;

import java.util.concurrent.TimeUnit;

public class setValuesWithPomWithComponents {
    public static void main(String[] args) {
        //1. Launch the targety app
        AppiumDriver<MobileElement> appiumDriver = AppiumDriveEx.getAndroidDriver();
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Click on login Label
        MobileElement loginLabel = appiumDriver.findElementByAccessibilityId("Login");
        loginLabel.click();

        //3. input username
        LoginPageWithComponents loginPage = new LoginPageWithComponents(appiumDriver);
        loginPage.credentialForm().inputUsername("test@test.com");

        //4. input password
        loginPage.credentialForm().inputPassword("Test123!");

        //5. Click on login btn
        loginPage.clickOnLoginBtn();

    }
}
