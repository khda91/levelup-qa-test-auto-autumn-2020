package ru.levelup.qa.at.taf.skeleton.services.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBeMoreThan;

public class YandexMarketCategoryProductPage extends AbstractYandexMarketPage {

    private List<ProductSnippetPageComposite> productCards;

    @FindBy(xpath = "//a/span[text()='Сравнить']")
    private WebElement compareButton;

    public YandexMarketCategoryProductPage(WebDriver driver) {
        super(driver);
    }

    public String addProductToCompare(int productNumber) {
        initProductCards();
        productCards.get(productNumber - 1).addToCompare();
        return productCards.get(productNumber - 1).getProductName();
    }

    private List<ProductSnippetPageComposite> initProductCards() {
        productCards = webDriverWait.until(numberOfElementsToBeMoreThan(cssSelector("[data-autotest-id='product-snippet']"), 3))
                .stream()
                .map(e -> new ProductSnippetPageComposite(driver, e))
                .collect(Collectors.toList());
        return productCards;
    }

    public void clickCompareButton() {
        webDriverWait.until(elementToBeClickable(compareButton)).click();
    }

}
