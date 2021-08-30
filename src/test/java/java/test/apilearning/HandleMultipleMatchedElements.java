package test.apilearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AppiumDriveEx;

import java.util.List;

public class HandleMultipleMatchedElements {
    public static void main(String[] args) throws InterruptedException {
        //Start an appium session
        AppiumDriver<MobileElement> appiumDriver = AppiumDriveEx.getAndroidDriver();

        //Click on login label
        MobileElement loginLabel = appiumDriver.findElementByAccessibilityId("Login");
        loginLabel.click();

        //Find elements those are matched //*[@text="Login"]
        WebDriverWait wait = new WebDriverWait(appiumDriver, 30L);
        wait.until(ExpectedConditions.numberOfElementsToBe(MobileBy.xpath("//*[@text=\"Login\"]"), 2));

        List<MobileElement> loginTextElements = appiumDriver.findElementsByXPath("//*[@text=\"Login\"]");

        final int LOGIN_TEXT_FROM_INDEX = 0;
        final int LOGIN_MENU_FROM_INDEX = 1;

        loginTextElements.get(LOGIN_TEXT_FROM_INDEX).click();
        loginTextElements.get(LOGIN_MENU_FROM_INDEX).click();


    }
}
