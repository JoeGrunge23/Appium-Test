package test.pom;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.pages.LoginPage;
import models.pages.LoginPageMethodChaining;
import utils.AppiumDriveEx;

import java.util.concurrent.TimeUnit;

public class setValuesWithPomMethodChaining {
    public static void main(String[] args) {
    //1. Launch the targety app
        AppiumDriver<MobileElement> appiumDriver = AppiumDriveEx.getAndroidDriver();
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    //2. Click on login Label
        MobileElement loginLabel = appiumDriver.findElementByAccessibilityId("Login");
        loginLabel.click();

        //3. input username, password , and click
        LoginPageMethodChaining loginPage = new LoginPageMethodChaining(appiumDriver);
        loginPage
                .inputUsername("test@test.com")
                .inputPassword("Test")
                .clickOnLoginBtn();


    }
}
