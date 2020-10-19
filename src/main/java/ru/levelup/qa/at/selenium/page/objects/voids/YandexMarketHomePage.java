package ru.levelup.qa.at.selenium.page.objects.voids;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class YandexMarketHomePage extends AbstractYandexMarketPage {

    private static final String HOME_PAGE_URL = "https://market.yandex.ru/";

    @FindBy(css = "[data-zone-name='category-link']")
    private List<WebElement> categoryList;

    public YandexMarketHomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.navigate().to(HOME_PAGE_URL);
    }

    public void selectProductCategory(String categoryName) {
        clickToElementFromListByText(categoryList, categoryName);
    }
}
