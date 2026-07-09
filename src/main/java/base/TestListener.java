package base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends BaseClass implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            Object testClass = result.getInstance();
            WebDriver driver = ((BaseClass) testClass).driver;
            Screenshots.captureScreenshot(driver, result.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
