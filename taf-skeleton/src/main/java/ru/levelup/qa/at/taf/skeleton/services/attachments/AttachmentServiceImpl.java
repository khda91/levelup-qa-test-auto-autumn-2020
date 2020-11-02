package ru.levelup.qa.at.taf.skeleton.services.attachments;


import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.levelup.qa.at.taf.skeleton.services.driver.DriverSingleton;

import static ru.levelup.qa.at.taf.skeleton.utils.DateUtils.getCurrentTimeAsString;

public class AttachmentServiceImpl implements AttachmentService {

    public AttachmentServiceImpl() {
    }

    @Override
    public void attachScreenshot() {
        byte[] screenshot = ((TakesScreenshot) DriverSingleton.getDriver()).getScreenshotAs(OutputType.BYTES);
        Allure.getLifecycle().addAttachment("screenshot" + getCurrentTimeAsString(), "image/png", "png", screenshot);
    }

    @Override
    public void attachPageSource() {
        Allure.addAttachment("pageSource" + getCurrentTimeAsString() + ".html", "text/html", DriverSingleton.getDriver().getPageSource());
    }

    @Override
    public void attachPageName() {

    }

    @Override
    public void attachPageUrl() {

    }
}
