package utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumDriveEx {
    public static AndroidDriver<MobileElement> getAndroidDriver() {

        //Driver instance
        AndroidDriver<MobileElement> androidDriver = null;

        try {
            //Set DesiredCapabilities to send to Appium server
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityTypeEx.PLATFORM_NAME, "Android");
            desiredCapabilities.setCapability(MobileCapabilityTypeEx.AUTOMATION_NAME, "uiautomator2");
            desiredCapabilities.setCapability(MobileCapabilityTypeEx.UDID, "emulator-5554");
            desiredCapabilities.setCapability(MobileCapabilityTypeEx.APP_PACKAGE, "com.wdiodemoapp");
            desiredCapabilities.setCapability(MobileCapabilityTypeEx.APP_ACTIVITY, "com.wdiodemoapp.MainActivity");
            desiredCapabilities.setCapability(MobileCapabilityTypeEx.NEW_COMMAND_TIMEOUT, 120);

            //Set the Appium server URL to connect
            //Instantiate from java.net
            URL appiumServer = new URL("http://localhost:4723/wd/hub");

            androidDriver = new AndroidDriver<MobileElement>(appiumServer, desiredCapabilities);
            androidDriver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);

            MobileElement loginLabel = androidDriver.findElementByAccessibilityId("Login");
            loginLabel.click();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return androidDriver;
    }
}
