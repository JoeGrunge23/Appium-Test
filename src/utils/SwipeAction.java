package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import java.time.Duration;

public class SwipeAction {

    private AppiumDriver<MobileElement> appiumDriver;
    private TouchAction touchAction;
    private PointOption startPoint;
    private PointOption endPoint;


    public SwipeAction(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
        touchAction = new TouchAction(this.appiumDriver);

        //Get mobile screen sizes
        Dimension windowSize  = this.appiumDriver.manage().window().getSize();
        int screenHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();

        //init start point and end points to touch and release
        int xStartPoint = 50 * screenWidth/100;
        int xEndPoint = 10 * screenWidth/100;
        int yStartPoint = 50 * screenHeight / 100;
        int yEndPoint = yStartPoint ;

        //perform the touch actions
        this.startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        this.endPoint = new PointOption().withCoordinates(xEndPoint,    yEndPoint);

    }

    public void swipeFromLeftToRight(int times) {
        for (int initTime = 0; initTime < times; initTime++) {
            this.swipeFromLeftToRight();
        }

    }

    public void swipeFromRightToLeft(int times) {
        for (int initTime = 0; initTime < times; initTime++) {
            this.swipeFromRightToLeft();
        }

    }

    public void swipeFromLeftToRight() {
        //Scroll from left to right
        touchAction
                .press(endPoint)
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                .moveTo(startPoint)
                .release()
                .perform();
    }

    public void swipeFromRightToLeft() {
        //Scroll up from right to left
        touchAction
                .press(startPoint)
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                .moveTo(endPoint)
                .release()
                .perform();
    }
}
