package test.apilearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import utils.AppiumDriveEx;

import java.time.Duration;

public class PutAppInBackground {
    public static void main(String[] args) {
        //Init a session with appium server
        AndroidDriver<MobileElement>  androidDriver = AppiumDriveEx.getAndroidDriver();

        //Go to login form and input username and password
        //2. Click on login Label
        MobileElement loginLabel = androidDriver.findElementByAccessibilityId("Login");
        loginLabel.click();

        //3. input username
        MobileElement emailTxtBx = androidDriver.findElementByAccessibilityId("input-email");
        emailTxtBx.sendKeys("tuhuynh@maildomain.com");

        //4. Click on login btn
        MobileElement passwordTxtBx = androidDriver.findElementByAccessibilityId("input-password");
        passwordTxtBx.sendKeys("password");

        //5. Click on login btn
        MobileElement loginBtn = androidDriver.findElementByAccessibilityId("button-LOGIN");
        loginBtn.click();
        //Put the app in background for 5 seconds
        androidDriver.runAppInBackground(Duration.ofSeconds(5));
        //
        //


    }
}
