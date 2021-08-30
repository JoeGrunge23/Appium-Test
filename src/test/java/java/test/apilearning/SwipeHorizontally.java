package test.apilearning;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AppiumDriveEx;
import utils.SwipeAction;

public class SwipeHorizontally {
    public static void main(String[] args) {

        //Create a session
        AppiumDriver appiumDriver = AppiumDriveEx.getAndroidDriver();

        //Click swipe label
        appiumDriver.findElementByAccessibilityId("Swipe").click();

        //Make sure I'm on the target screen
        WebDriverWait wait = new WebDriverWait(appiumDriver, 30L);
        wait.until(ExpectedConditions.visibilityOf(appiumDriver.findElementByXPath("//*[@text='Swipe horizontal']")));
        SwipeAction swipeAction = new SwipeAction(appiumDriver);
        swipeAction.swipeFromRightToLeft();
        swipeAction.swipeFromLeftToRight();

        swipeAction.swipeFromRightToLeft(5);





    }
}
