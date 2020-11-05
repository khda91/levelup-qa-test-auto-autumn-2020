package ru.levelup.qa.at.multithreading;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.qa.at.utils.Utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SimpleMultythreadingTest {

    ThreadLocal<WebDriver> driverThreadLocal;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driverThreadLocal = new ThreadLocal<>();
        WebDriver driver = new ChromeDriver();
        driverThreadLocal.set(driver);
    }

    @Test( threadPoolSize = 3, invocationCount = 2)
    public void openYandexMarketHomePage() {
        WebDriver driver = driverThreadLocal.get();
        driver.navigate().to("https://market.yandex.ru/");
        Utils.sleepMillis(2000);
        assertThat(driver.getTitle(),
                equalTo("Яндекс.Маркет — выбор и покупка товаров из проверенных интернет-магазинов"));
    }

    @AfterMethod
    public void afterClass() {
        driverThreadLocal.get().quit();
    }
}
