package test.apilearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.pages.LoginPage;
import utils.AppiumDriveEx;

import java.util.concurrent.TimeUnit;

public class setValuesWithPomMainInteractionMethods {
    public static void main(String[] args) {
    //1. Launch the targety app
        AppiumDriver<MobileElement> appiumDriver = AppiumDriveEx.getAndroidDriver();
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    //2. Click on login Label
        MobileElement loginLabel = appiumDriver.findElementByAccessibilityId("Login");
        loginLabel.click();

        //3. input username
        LoginPage loginPage = new LoginPage(appiumDriver);
        loginPage.inputUsername("test@test.com");

        //4. Click on login btn
        loginPage.inputPassword("Test123!");
        //5. Click on login btn
        loginPage.clickOnLoginBtn();

    }
}
