package ru.levelup.qa.at.selenium.basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.qa.at.utils.Utils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;

public class SimpleSeleniumCssSelectorsLocatorsTest {

    private WebDriver driver;

    @Test
    public void openYandexMarketHomePageCssId() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://market.yandex.ru/");

        Utils.sleepMillis(2000);

        WebElement logoPartMarket = driver.findElement(By.cssSelector("#logoPartMarket"));
        System.out.println(logoPartMarket.getText());

        driver.close();
    }

    @Test
    public void openYandexMarketHomePageCssClassName() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://market.yandex.ru/");

        Utils.sleepMillis(2000);

        WebElement classNameWebElement = driver.findElement(By.cssSelector("._2ZRlRXSh_x"));
        System.out.println(classNameWebElement.getText());

        classNameWebElement.click();

        Utils.sleepMillis(2000);

        driver.close();
    }

    @Test
    public void openYandexMarketHomePageCssTagName() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://market.yandex.ru/");

        Utils.sleepMillis(2000);

        List<WebElement> divs = driver.findElements(By.cssSelector("div"));
        System.out.println(divs.size());

        Utils.sleepMillis(2000);

        driver.close();
    }

    @Test
    public void openYandexMarketHomePageCssCombineSearch() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://market.yandex.ru/");

        Utils.sleepMillis(2000);

        List<WebElement> divs = driver.findElements(By.cssSelector("div[data-zone-name='category-link'] a"));
        System.out.println(divs.size());
        divs.forEach(we -> System.out.println(we.getText()));

        Utils.sleepMillis(2000);

        driver.close();
    }

    @Test
    public void openYandexMarketHomePageCssCombineSearchTest() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://market.yandex.ru/");

        Utils.sleepMillis(2000);

        List<WebElement> divs = driver.findElements(By.cssSelector("div[data-zone-name='category-link'] a"));
        List<WebElement> visibleMenuItems = divs.stream().filter(WebElement::isDisplayed).collect(Collectors.toList());

        assertThat(visibleMenuItems, hasSize(13));
        List<String> expected = Arrays.asList("Покупки",
                "Скидки",
                "Электроника",
                "Бытовая техника",
                "Компьютеры",
                "Детям",
                "Ремонт",
                "Дом",
                "Мебель",
                "Авто",
                "Красота",
                "Здоровье",
                "Журнал Маркета");

        assertThat(visibleMenuItems.stream().map(WebElement::getText).collect(Collectors.toList()),
                containsInAnyOrder(expected.toArray(new String[expected.size()])));

        Utils.sleepMillis(2000);

        driver.close();
    }

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox", "start-maximized", "--headless");

        driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("https://market.yandex.ru/");
    }

    @Test
    public void openYandexMarketHomePageCssCombineSearchHeadless() {

        Utils.sleepMillis(2000);

        List<WebElement> divs = driver.findElements(By.cssSelector("div[data-zone-name='category-link'] a"));
        List<WebElement> visibleMenuItems = divs.stream().filter(WebElement::isDisplayed).collect(Collectors.toList());

        assertThat(visibleMenuItems, hasSize(13));
        List<String> expected = Arrays.asList("Покупки",
                "Скидки",
                "Электроника",
                "Бытовая техника",
                "Компьютеры",
                "Детям",
                "Ремонт",
                "Дом",
                "Мебель",
                "Авто",
                "Красота",
                "Здоровье",
                "Журнал Маркета");

        assertThat(visibleMenuItems.stream().map(WebElement::getText).collect(Collectors.toList()),
                containsInAnyOrder(expected.toArray(new String[expected.size()])));

        Utils.sleepMillis(2000);

    }

    @AfterMethod
    public void tearDown() {
        TakesScreenshot sc = (TakesScreenshot) this.driver;
        File screenshotAFile = sc.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotAFile, new File("sampleScreenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.driver.close();
    }
}
