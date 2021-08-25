package test.apilearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utils.AppiumDriveEx;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandleMultipleMatchedElements {
    public static void main(String[] args) throws InterruptedException {
        //Start an appium session
        AppiumDriver<MobileElement> appiumDriver = AppiumDriveEx.getAppiumDriver();

        //Click on login label
        MobileElement loginLabel = appiumDriver.findElementByAccessibilityId("Login");
        loginLabel.click();

        //Find elements those are matched //*[@text="Login"]
//        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(2000);
        List<MobileElement> loginTextElements = appiumDriver.findElementsByXPath("//*[@text=\"Login\"]");
        //This will display how many elemtnts with text = login is there
        System.out.println("How many elements matched: " + loginTextElements.size());

        final int LOGIN_TEXT_FROM_INDEX = 0;
        final int LOGIN_MENU_FROM_INDEX = 1;

        loginTextElements.get(LOGIN_TEXT_FROM_INDEX).click();
        loginTextElements.get(LOGIN_MENU_FROM_INDEX).click();


    }
}
