package ru.levelup.qa.at.selenium.page.objects.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class YandexMarketCompareProductPage {

    private WebDriver driver;

    private WebDriverWait webDriverWait;

    @FindBy(css = ".LwwocgVx0q.zvRJMhRW-w")
    private List<WebElement> productCardList;

    public YandexMarketCompareProductPage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    public List<String> getComparedProductNames() {
        return productCardList.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
