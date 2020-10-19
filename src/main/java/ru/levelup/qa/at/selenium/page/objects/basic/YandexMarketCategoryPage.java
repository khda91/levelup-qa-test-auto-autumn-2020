package ru.levelup.qa.at.selenium.page.objects.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

public class YandexMarketCategoryPage {

    private WebDriver driver;

    private WebDriverWait webDriverWait;

    @FindBy(css = "[data-zone-name='link']")
    private List<WebElement> subCategoryList;

    public YandexMarketCategoryPage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    public YandexMarketCategoryProductPage selectSubCategory(String subCategoryName) {
        webDriverWait.until(visibilityOfAllElements(subCategoryList))
                .stream()
                .filter(we -> subCategoryName.equals(we.getText()))
                .findFirst()
                .get()
                .click();
        return new YandexMarketCategoryProductPage(driver);
    }
}
