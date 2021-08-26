package test.apilearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.AppiumDriveEx;

import java.io.File;
import java.io.IOException;

public class TakingScreenshot {
    public static void main(String[] args) {

        //Create a session
        AppiumDriver<MobileElement> appiumDriver = AppiumDriveEx.getAppiumDriver();

        //Navigate to form screen
        MobileElement formsLabel = appiumDriver.findElementByAccessibilityId("Forms");
        formsLabel.click();

        //Click on toggle button IF it's off
        MobileElement switchElement = appiumDriver.findElementByAccessibilityId("switch");
        MobileElement switchTextElement = appiumDriver.findElementByAccessibilityId("switch-text");
        final  boolean isSwitchOn = switchTextElement.getText().equals("Click to turn the switch OFF");

        if(!isSwitchOn) {
            switchElement.click();
        }

        //Click on drop down - > select the first option

        //Click on the drop down  element
        MobileElement dropdownMenuElement = appiumDriver.findElementByAccessibilityId("Dropdown");
        dropdownMenuElement.click();

        //Select the first option
        //findElementByXPath("//*[@text='webdriver.io is awesome']"); will find the text with webdriver.io is awesome
        MobileElement firstOption = appiumDriver.findElementByXPath("//*[@text='webdriver.io is awesome']");
        firstOption.click();

        //Taking a screenshot
        File formScreenBased64Data = ((TakesScreenshot) appiumDriver).getScreenshotAs(OutputType.FILE);
        String formScreenFilePath = System.getProperty(("user.dir"), "/screenshot/" + "formsScreen.png");

        try {
            FileUtils.copyFile(formScreenBased64Data, new File(formScreenFilePath));

        } catch (IOException e) {
            e.printStackTrace();
        }

        //
        //
        //


    }
}
