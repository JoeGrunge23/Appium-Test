package test.pom;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.pages.LoginPage;
import utils.AppiumDriveEx;

import java.util.concurrent.TimeUnit;

public class setValuesWithPom {
    public static void main(String[] args) {
    //1. Launch the targety app
        AppiumDriver<MobileElement> appiumDriver = AppiumDriveEx.getAndroidDriver();
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    //2. Click on login Label
        MobileElement loginLabel = appiumDriver.findElementByAccessibilityId("Login");
        loginLabel.click();

        //3. input username
        LoginPage loginPage = new LoginPage(appiumDriver);
        loginPage.username().sendKeys("tuhuynh@maildomain.com");

        //4. Click on login btn
        loginPage.password().sendKeys("password");

        //5. Click on login btn
        loginPage.loginBtn().click();

    }
}
