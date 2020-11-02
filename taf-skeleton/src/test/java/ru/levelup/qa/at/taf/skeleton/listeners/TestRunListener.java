package ru.levelup.qa.at.taf.skeleton.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.levelup.qa.at.taf.skeleton.services.attachments.AttachmentService;
import ru.levelup.qa.at.taf.skeleton.services.attachments.AttachmentServiceImpl;

public class TestRunListener implements ITestListener {

    AttachmentService attachmentService = new AttachmentServiceImpl();

    @Override
    public void onTestFailure(ITestResult result) {
        attachmentService.attachScreenshot();
        attachmentService.attachPageSource();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        attachmentService.attachScreenshot();
        attachmentService.attachPageSource();
    }
}
