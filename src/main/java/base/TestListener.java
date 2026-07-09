package base;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends BaseClass implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Screenshots.captureScreenshot(driver, result.getName());
    }

}
