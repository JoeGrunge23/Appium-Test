package test.apilearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utils.AppiumDriveEx;

public class clickOneElement {
    public static void main(String[] args) {

            //Driver instance
            AppiumDriver<MobileElement> appiumDriver = AppiumDriveEx.getAndroidDriver();
            MobileElement loginLabel = appiumDriver.findElementByAccessibilityId("Login");
            loginLabel.click();

    }
}
