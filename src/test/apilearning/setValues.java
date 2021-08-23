package test.apilearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utils.AppiumDriveEx;

public class setValues {
    public static void main(String[] args) {
    //1. Launch the targety app
        AppiumDriver<MobileElement> appiumDriver = AppiumDriveEx.getAppiumDriver();

    //2. Click on login Label
        MobileElement loginLabel = appiumDriver.findElementByAccessibilityId("Login");
        loginLabel.click();

          //3. input username
        MobileElement emailTxtBx = appiumDriver.findElementByAccessibilityId("input-email");
        emailTxtBx.sendKeys("tuhuynh@maildomain.com");

        //4. Click on login btn
        MobileElement passwordTxtBx = appiumDriver.findElementByAccessibilityId("input-password");
        passwordTxtBx.sendKeys("password");

        //5. Click on login btn
        MobileElement loginBtn = appiumDriver.findElementByAccessibilityId("button-LOGIN");
        loginBtn.click();

    }
}
