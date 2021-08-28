package test.apilearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AppiumDriveEx;
import utils.SwipeAction;

import java.time.Duration;

public class SwipeVertically {
    public static void main(String[] args) {

        //Create a session
        AppiumDriver appiumDriver = AppiumDriveEx.getAppiumDriver();

        //Click form label
        appiumDriver.findElementByAccessibilityId("Forms").click();

        //Make sure I'm on the target screen
        WebDriverWait wait = new WebDriverWait(appiumDriver, 30L);
        wait.until(ExpectedConditions.visibilityOf(appiumDriver.findElementByAccessibilityId("switch-text")));

        SwipeAction swipeAction = new SwipeAction(appiumDriver);
        swipeAction.swipeFromLeftToRight();


//        //Get mobile screen sizes
//        Dimension windowSize  = appiumDriver.manage().window().getSize();
//        int screenHeight = windowSize.getHeight();
//        int screenWidth = windowSize.getWidth();
//
//
//        //init start point and end points to touch and release
//        int xStartPoint = 50 *  screenWidth/100;
//        int xEndPoint = xStartPoint;
//        int yStartPoint = 90 * screenHeight / 100;
//        int yEndPoint = 10 * screenHeight / 100;
//
//        //perform the touch actions
//        PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
//        PointOption endPoint = new PointOption().withCoordinates(xEndPoint,    yEndPoint);
//
//        TouchAction touchAction = new TouchAction(appiumDriver);
//
//        //Scroll up from bottom to top
//        touchAction
//                .press(startPoint)
//                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
//                .moveTo(endPoint)
//                .release()
//                .perform();
//
//        //Scrop down
//        touchAction
//                .press(endPoint)
//                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
//                .moveTo(startPoint)
//                .release()
//                .perform();



    }
}
