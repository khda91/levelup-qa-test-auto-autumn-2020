package ru.levelup.qa.at.taf.skeleton.services.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class YandexMarketCompareProductPage extends AbstractYandexMarketPage {

    @FindBy(css = ".LwwocgVx0q.zvRJMhRW-w")
    private List<WebElement> productCardList;

    public YandexMarketCompareProductPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getComparedProductNames() {
        return productCardList.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
