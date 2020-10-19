package ru.levelup.qa.at.selenium.page.objects.statics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexMarketHomePage {

    private static final String HOME_PAGE_URL = "https://market.yandex.ru/";

    private static WebDriver webDriver;

    public static void open(WebDriver driver) {
        webDriver = driver;
        driver.navigate().to(HOME_PAGE_URL);
    }

    public static void selectProductCategory(String categoryName) {
        new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("[data-zone-name='category-link']"), 3))
                .stream()
                .filter(we -> categoryName.equals(we.getText()))
                .findFirst()
                .get()
                .click();
    }
}
