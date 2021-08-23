package test.apilearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.AppiumDriveEx;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class clickOneElement {
    public static void main(String[] args) {

            //Driver instance
            AppiumDriver<MobileElement> appiumDriver = AppiumDriveEx.getAppiumDriver();
            MobileElement loginLabel = appiumDriver.findElementByAccessibilityId("Login");
            loginLabel.click();

    }
}
