package test.apilearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class clickOneElement {
    public static void main(String[] args) {
        try {
            //Driver instance
            AppiumDriver<MobileElement> appiumDriver;

            //Set DesiredCapabilities to send to Appium server
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
            desiredCapabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
            desiredCapabilities.setCapability("appPackage", "com.wdiodemoapp");
            desiredCapabilities.setCapability("appActivity", "com.wdiodemoapp.MainActivity");

            //Set the Appium server URL to connect
            //Instantiate from java.net
            URL appiumServer = new URL("http://localhost:4723/wd/hub");

            appiumDriver = new AppiumDriver<>(appiumServer, desiredCapabilities);
            appiumDriver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
            MobileElement loginLabel = appiumDriver.findElementByAccessibilityId("Login");
            loginLabel.click();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
