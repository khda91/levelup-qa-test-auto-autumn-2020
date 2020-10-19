package ru.levelup.qa.at.selenium.page.objects.statics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;

public class YandexMarketCategoryPage {

    private static WebDriver driver;

    public static void init(WebDriver webDriver) {
        driver = webDriver;
    }

    public static void selectSubCategory(String subCategoryName) {
        new WebDriverWait(driver, 5).until(visibilityOfAllElementsLocatedBy(By.cssSelector("[data-zone-name='link']")))
                .stream()
                .filter(we -> subCategoryName.equals(we.getText()))
                .findFirst()
                .get()
                .click();
    }
}
