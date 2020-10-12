package ru.levelup.qa.at.selenium.basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import ru.levelup.qa.at.utils.Utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SimpleSeleniumTest {

    @Test
    public void openYandexMarketHomePage() {
        System.setProperty("webdriver.chrome.driver", this.getClass().getClassLoader().getResource("selenium/mac/chromedriver").getFile());
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://market.yandex.ru/");
        Utils.sleepMillis(2000);
        assertThat(driver.getTitle(),
                equalTo("Яндекс.Маркет — выбор и покупка товаров из проверенных интернет-магазинов"));
        driver.close();
    }

    @Test
    public void openYandexMarketHomePageHeadless() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox", "start-maximized", "--headless");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("https://market.yandex.ru/");

        Utils.sleepMillis(2000);

        assertThat(driver.getTitle(),
                equalTo("Яндекс.Маркет — выбор и покупка товаров из проверенных интернет-магазинов"));
        driver.close();
    }

    @Test
    public void openYandexMarketHomePageWithWebDriverManager() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("https://market.yandex.ru/");
        Utils.sleepMillis(2000);
        assertThat(driver.getTitle(),
                equalTo("Яндекс.Маркет — выбор и покупка товаров из проверенных интернет-магазинов"));
        driver.close();
    }

}
