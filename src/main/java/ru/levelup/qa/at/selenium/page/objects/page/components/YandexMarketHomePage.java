package ru.levelup.qa.at.selenium.page.objects.page.components;

import org.openqa.selenium.WebDriver;

public class YandexMarketHomePage extends AbstractYandexMarketPage {

    private static final String HOME_PAGE_URL = "https://market.yandex.ru/";

    public YandexMarketHomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.navigate().to(HOME_PAGE_URL);
    }
}
