package test.apilearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utils.AppiumDriveEx;

public class HandleToggleButton {
    public static void main(String[] args) {

        //Launch appium session
        AppiumDriver<MobileElement> appiumDriver = AppiumDriveEx.getAppiumDriver();

        //Click on the [Forms label]
        MobileElement formsLabel = appiumDriver.findElementByAccessibilityId("Forms");
        formsLabel.click();

        //Get the toggle label  value before interacting with the switch
        MobileElement switchTextElement = appiumDriver.findElementByAccessibilityId("switch-text");
        System.out.println("Label Text before interacting toggle button " + switchTextElement.getText());

        // Click on the toggle button
        MobileElement switchElement = appiumDriver.findElementByAccessibilityId("switch");
        switchElement.click();


        // Get  the toggle label value before interacting with the switch
        System.out.println("Label Text after interacting toggle button " + switchTextElement.getText());

    }
}
