package ru.levelup.qa.at.design.patterns.factory.method;

import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class WebDriverFactoryTest {

    @Test
    public void testChromeWebDriverFactory() {
        WebDriver driver = WebDriverFactory.createWebDriver(Browser.getBrowser("CHrome"));
        assertThat(driver, Matchers.notNullValue());
        driver.quit();
    }

    @Test
    public void testFirefoxWebDriverFactory() {
        WebDriver driver = WebDriverFactory.createWebDriver(Browser.getBrowser("FireFOX"));
        assertThat(driver, Matchers.notNullValue());
        driver.quit();
    }
}
