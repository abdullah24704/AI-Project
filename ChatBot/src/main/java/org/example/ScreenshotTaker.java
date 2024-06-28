package org.example;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;

public class ScreenshotTaker {

    public void takeScreenshot() {
        try {
            // Create a Robot instance
            Robot robot = new Robot();
            String directoryPath = "C:\\Users\\quemi\\Pictures\\java";
            // Get the screen size
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

            // Capture the screen as a BufferedImage
            BufferedImage screenFullImage = robot.createScreenCapture(screenRect);

            // Generate a unique file name
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String filePath = directoryPath + File.separator + "screenshot_" + timestamp + ".png";

            // Save the screenshot to a file
            File outputFile = new File(filePath);
            ImageIO.write(screenFullImage, "png", outputFile);

            System.out.println("A full screenshot saved at: " + filePath);

        } catch (AWTException | IOException ex) {
            System.err.println(ex);
        }
    }
}
