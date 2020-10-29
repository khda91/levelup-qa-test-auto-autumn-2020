package ru.levelup.qa.at.allure;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.levelup.qa.at.allure.config.DriverSingleton;

public class TestResultsListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
//        byte[] screenshotAs = ((TakesScreenshot) AbstractBaseTest.webDriver).getScreenshotAs(OutputType.BYTES); не надо так делать
        byte[] screenshotAs = ((TakesScreenshot) DriverSingleton.getDriver()).getScreenshotAs(OutputType.BYTES);
        Allure.getLifecycle().addAttachment("screenshot", "image/png", ".png", screenshotAs);
    }
}
