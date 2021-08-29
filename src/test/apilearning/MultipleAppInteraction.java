package test.apilearning;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import utils.AppiumDriveEx;

import java.time.Duration;

public class MultipleAppInteraction {
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
        androidDriver.runAppInBackground(Duration.ofSeconds(-1));

        //Open the Settings Application - com.android.settings
        androidDriver.activateApp("com.android.settings");

        //Go to wifi Settings
         androidDriver.
                 findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]")
                 .click();
        androidDriver.
                findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]")
                .click();

        //Turn the wifi ON of it's off and try to turn off then on if it's already ON
        try {
            MobileElement wifiOnElement = androidDriver.findElementByXPath("//*[text='ON']");
            By wifiOffSelector = MobileBy.xpath("//*[text='OFF']");

            MobileElement wifiOffElement;
            boolean isWifiOn = wifiOnElement.isDisplayed();

            if (isWifiOn) {

                //Toggle the wifi off
                wifiOnElement.click();

                //Toggle it On again

                wifiOffElement = androidDriver.findElement(wifiOffSelector);
                wifiOffElement.click();

            } else {
                wifiOffElement = androidDriver.findElement(wifiOffSelector);
                wifiOffElement.click();
            }
        } catch (NotFoundException notFoundException) {
            notFoundException.printStackTrace();
        }

        //RE-LAUANCH the testing app again
        androidDriver.activateApp("com.wdiodemoapp");

        //Continue to interact with other elements on the application
        androidDriver.findElementById("android:id/button1").click();
    }
}
