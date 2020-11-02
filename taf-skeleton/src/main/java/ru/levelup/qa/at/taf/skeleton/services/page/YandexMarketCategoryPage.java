package ru.levelup.qa.at.taf.skeleton.services.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

public class YandexMarketCategoryPage extends AbstractYandexMarketPage {

    @FindBy(css = "[data-zone-name='link']")
    private List<WebElement> subCategoryList;

    public YandexMarketCategoryPage(WebDriver driver) {
        super(driver);
    }

    public void selectSubCategory(String subCategoryName) {
        clickToElementFromListByText(webDriverWait.until(visibilityOfAllElements(subCategoryList)), subCategoryName);
    }
}
