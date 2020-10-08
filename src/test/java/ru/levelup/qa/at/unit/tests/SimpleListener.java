package ru.levelup.qa.at.unit.tests;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class SimpleListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Started test: '" + result.getTestName() + "'");
    }
}
