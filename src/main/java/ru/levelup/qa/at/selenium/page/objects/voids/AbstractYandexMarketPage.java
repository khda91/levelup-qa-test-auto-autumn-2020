package ru.levelup.qa.at.selenium.page.objects.voids;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class AbstractYandexMarketPage {

    protected WebDriver driver;

    protected WebDriverWait webDriverWait;

    protected AbstractYandexMarketPage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    protected void clickToElementFromListByText(final List<WebElement> elements, final String text) {
        elements
                .stream()
                .filter(we -> text.equals(we.getText()))
                .findFirst()
                .get()
                .click();
    }
}
