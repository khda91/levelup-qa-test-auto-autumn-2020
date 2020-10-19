package ru.levelup.qa.at.selenium.page.objects.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class YandexMarketHomePage {

    private static final String HOME_PAGE_URL = "https://market.yandex.ru/";

    private WebDriver driver;

    private WebDriverWait webDriverWait;

    @FindBy(css = "[data-zone-name='category-link']")
    private List<WebElement> categoryList;

    public YandexMarketHomePage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    public YandexMarketHomePage open() {
        driver.navigate().to(HOME_PAGE_URL);
        return new YandexMarketHomePage(driver);
    }

    public YandexMarketCategoryPage selectProductCategory(String categoryName) {
        categoryList
                .stream()
                .filter(we -> categoryName.equals(we.getText()))
                .findFirst()
                .get()
                .click();
        return new YandexMarketCategoryPage(driver);
    }
}
