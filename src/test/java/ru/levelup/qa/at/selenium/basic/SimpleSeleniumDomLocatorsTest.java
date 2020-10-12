package ru.levelup.qa.at.selenium.basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import ru.levelup.qa.at.utils.Utils;

import java.util.List;

public class SimpleSeleniumDomLocatorsTest {

    @Test
    public void openYandexMarketHomePageDomId() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://market.yandex.ru/");

        Utils.sleepMillis(2000);

        WebElement logoPartMarket = driver.findElement(By.id("logoPartMarket"));
        System.out.println(logoPartMarket.getText());

        driver.close();
    }

    @Test
    public void openYandexMarketHomePageDomClassName() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://market.yandex.ru/");

        Utils.sleepMillis(2000);

        WebElement classNameWebElement = driver.findElement(By.className("_2ZRlRXSh_x"));
        System.out.println(classNameWebElement.getText());

        classNameWebElement.click();

        Utils.sleepMillis(2000);

        driver.close();
    }

    @Test
    public void openYandexMarketHomePageDomTagName() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://market.yandex.ru/");

        Utils.sleepMillis(2000);

        List<WebElement> divs = driver.findElements(By.tagName("div"));
        System.out.println(divs.size());

        Utils.sleepMillis(2000);

        driver.close();
    }

}
