package ru.levelup.qa.at.selenium.page.objects.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfNestedElementLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class YandexMarketCategoryProductPage {

    private WebDriver driver;

    private WebDriverWait webDriverWait;

    @FindBy(css = "[data-autotest-id='product-snippet']")
    private List<WebElement> productCardList;

    @FindBy(xpath = "//a/span[text()='Сравнить']")
    private WebElement compareButton;

    public YandexMarketCategoryProductPage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    public String addProductToCompare(int productNumber) {
        WebElement productCard = productCardList.get(productNumber - 1);
        WebElement addToCompare = webDriverWait.until(presenceOfNestedElementLocatedBy(productCard,
                xpath(".//div[contains(@aria-label, 'сравнению')]")));
        new Actions(driver)
                .moveToElement(addToCompare)
                .click()
                .build()
                .perform();
        return webDriverWait.until(visibilityOf(productCard.findElement(xpath(".//div//child::h3[@data-zone-name='title']")))).getText().trim();
    }

    public YandexMarketCompareProductPage clickCompareButton() {
        webDriverWait.until(elementToBeClickable(compareButton)).click();
        return new YandexMarketCompareProductPage(driver);
    }

}
