package test.apilearning;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.screenrecording.CanRecordScreen;
import utils.AppiumDriveEx;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class RecordVideo {
    public static void main(String[] args) {
        //Init a seassion with appium server
        AndroidDriver<MobileElement> appiumDriver = AppiumDriveEx.getAndroidDriver();

        //Start recording
        ((CanRecordScreen) appiumDriver).startRecordingScreen();


        //To do something for the test to simulate real user actions

        //2. Click on login Label
        MobileElement loginLabel = appiumDriver.findElementByAccessibilityId("Login");
        loginLabel.click();

        //3. input username
        MobileElement emailTxtBx = appiumDriver.findElementByAccessibilityId("input-email");
        emailTxtBx.sendKeys("tuhuynh@maildomain.com");

        //4. Click on login btn
        MobileElement passwordTxtBx = appiumDriver.findElementByAccessibilityId("input-password");
        passwordTxtBx.sendKeys("password");

        //5. Click on login btn
        MobileElement loginBtn = appiumDriver.findElementByAccessibilityId("button-LOGIN");
        loginBtn.click();
        //Strop Recrording
        String video = ((CanRecordScreen) appiumDriver).stopRecordingScreen();

        //Save the recorded
        byte[] decodeVideo = Base64.getMimeDecoder().decode(video);

        try {
            Path testVideoDir = Paths.get(System.getProperty("user.dir") + "/videos");
            Files.createDirectories(testVideoDir);

            //test-date.mp4
            Path testVideosFileLocation =
                    Paths.get(testVideoDir.toString(),
                            String.format("%s-%d.%s",
                            "test", System.currentTimeMillis(),
                            "mp4"));
            Files.write(testVideosFileLocation, decodeVideo);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
