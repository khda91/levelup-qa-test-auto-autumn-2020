package ru.levelup.qa.at.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.levelup.qa.at.allure.config.DriverSingleton;

public abstract class AbstractBaseTest {

    protected WebDriver driver;
    public static WebDriver webDriver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        driver = DriverSingleton.getDriver();
        webDriver = driver;
//        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        DriverSingleton.closeDriver();
    }
}
