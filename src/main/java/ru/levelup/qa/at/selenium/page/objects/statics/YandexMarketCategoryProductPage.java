package ru.levelup.qa.at.selenium.page.objects.statics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBeMoreThan;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfNestedElementLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class YandexMarketCategoryProductPage {

    private static WebDriver driver;

    public static void init(WebDriver webDriver) {
        driver = webDriver;
    }

    public static String addProductToCompare(int productNumber) {
        List<WebElement> productCards = new WebDriverWait(driver, 5).until(numberOfElementsToBeMoreThan(By.cssSelector("[data-autotest-id='product-snippet']"), 3));
        WebElement productCard = productCards.get(productNumber - 1);
        WebElement addToCompare = new WebDriverWait(driver, 5).until(presenceOfNestedElementLocatedBy(productCard,
                xpath(".//div[contains(@aria-label, 'сравнению')]")));
        new Actions(driver)
                .moveToElement(addToCompare)
                .click()
                .build()
                .perform();
        return new WebDriverWait(driver, 5).until(visibilityOf(productCard.findElement(xpath(".//div//child::h3[@data-zone-name='title']")))).getText().trim();
    }

    public static void clickCompareButton() {
        new WebDriverWait(driver, 5).until(elementToBeClickable(By.xpath("//a/span[text()='Сравнить']"))).click();
    }

}
