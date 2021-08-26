package test.apilearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utils.AppiumDriveEx;

public class HandleDropDown {
    public static void main(String[] args) {
        //Setup the session
        AppiumDriver<MobileElement> appiumDriver = AppiumDriveEx.getAppiumDriver();

        //Go the forms
        MobileElement formsLabel = appiumDriver.findElementByAccessibilityId("Forms");
        formsLabel.click();

        //Click on the drop down  element
        MobileElement dropdownMenuElement = appiumDriver.findElementByAccessibilityId("Dropdown");
        dropdownMenuElement.click();

        //Select the first option
        //findElementByXPath("//*[@text='webdriver.io is awesome']"); will find the text with webdriver.io is awesome
        MobileElement firstOption = appiumDriver.findElementByXPath("//*[@text='webdriver.io is awesome']");
        firstOption.click();

        //

        try {
            Thread.sleep(3000);

        } catch (Exception e) {

        }
        //


    }
}
