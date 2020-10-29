package ru.levelup.qa.at.allure.config;

import org.openqa.selenium.WebDriver;
import ru.levelup.qa.at.design.patterns.factory.method.Browser;
import ru.levelup.qa.at.design.patterns.factory.method.WebDriverFactory;

public final class DriverSingleton {

    private static WebDriver driver;

    private DriverSingleton() {}

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = WebDriverFactory.createWebDriver(Browser.CHROME);
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }

}
