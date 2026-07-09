package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshots {

    public static void captureScreenshot(WebDriver driver, String testName) {
        try {
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File("./screenshots/" + testName + "_" + timeStamp + ".png");
            FileUtils.copyFile(source, destination);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
