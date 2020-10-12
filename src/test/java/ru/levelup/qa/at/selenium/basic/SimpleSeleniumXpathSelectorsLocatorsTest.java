package ru.levelup.qa.at.selenium.basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import ru.levelup.qa.at.utils.Utils;

import java.util.List;

public class SimpleSeleniumXpathSelectorsLocatorsTest {

    @Test
    public void openYandexMarketHomePageXPathId() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://market.yandex.ru/");

        Utils.sleepMillis(2000);

        WebElement logoPartMarket = driver.findElement(By.xpath("//*[@id='logoPartMarket']"));
        System.out.println(logoPartMarket.getText());

        driver.close();
    }

    @Test
    public void openYandexMarketHomePageXPathClassName() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://market.yandex.ru/");

        Utils.sleepMillis(2000);

        WebElement classNameWebElement = driver.findElement(By.xpath("//*[contains(@class, '_2ZRlRXSh_x')]"));
        System.out.println(classNameWebElement.getText());

        classNameWebElement.click();

        Utils.sleepMillis(2000);

        driver.close();
    }

    @Test
    public void openYandexMarketHomePageXpathTagName() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://market.yandex.ru/");

        Utils.sleepMillis(2000);

        List<WebElement> divs = driver.findElements(By.xpath("//div"));
        System.out.println(divs.size());

        Utils.sleepMillis(2000);

        driver.close();
    }

    @Test
    public void openYandexMarketHomePageXpathCombineSearch() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://market.yandex.ru/");

        Utils.sleepMillis(2000);

        List<WebElement> divs = driver.findElements(By.xpath("//div[@data-zone-name='category-link']/a"));
        System.out.println(divs.size());
        divs.forEach(we -> System.out.println(we.getText()));

        Utils.sleepMillis(2000);

        driver.close();
    }

}
