package ru.levelup.qa.at.selenium.basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import ru.levelup.qa.at.utils.Utils;

import java.util.ArrayList;

public class SeleniumWindowHandlesTest {

    @Test
    public void openYandexMarketHomePageSeveralTabs() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://market.yandex.ru/");

        Utils.sleepMillis(3000);

        ((JavascriptExecutor) driver).executeScript("window.open();");

        Utils.sleepMillis(1000);

        driver.navigate().to("https://ya.ru");

        Utils.sleepMillis(3000);

        driver.close();
    }

    @Test
    public void openYandexMarketHomePageSeveralTabsDriverQuit() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://market.yandex.ru/");

        Utils.sleepMillis(3000);

        ((JavascriptExecutor) driver).executeScript("window.open();");

        Utils.sleepMillis(1000);

        driver.navigate().to("https://ya.ru");

        Utils.sleepMillis(3000);

        driver.quit();
    }

    @Test
    public void openYandexMarketHomePageSeveralTabsWindowHandles() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://market.yandex.ru/");

        Utils.sleepMillis(3000);

        ((JavascriptExecutor) driver).executeScript("window.open();");

        Utils.sleepMillis(1000);

        ArrayList<String> driverWindowHandles = new ArrayList<>(driver.getWindowHandles());
        System.out.println(driverWindowHandles);

        driver.switchTo().window(driverWindowHandles.get(1));

        driver.navigate().to("https://ya.ru");

        Utils.sleepMillis(3000);

        driver.quit();
    }
}
