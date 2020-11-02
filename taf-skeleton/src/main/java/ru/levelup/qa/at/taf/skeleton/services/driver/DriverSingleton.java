package ru.levelup.qa.at.taf.skeleton.services.driver;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DriverSingleton {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        String browserName = System.getProperty("browser") == null ? "chrome" : System.getProperty("browser");
        if (driver == null) {
            driver = WebDriverFactory.createWebDriver(Browser.getBrowser(browserName));
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }

}
