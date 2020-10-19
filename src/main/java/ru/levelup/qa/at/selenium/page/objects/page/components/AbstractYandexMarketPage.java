package ru.levelup.qa.at.selenium.page.objects.page.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class AbstractYandexMarketPage extends AbstractBaseComposite {

    @FindBy(css = "[data-zone-name='category-link']")
    private List<WebElement> categoryList;

    protected AbstractYandexMarketPage(WebDriver driver) {
        super(driver);
    }

    public void selectProductCategory(String categoryName) {
        clickToElementFromListByText(categoryList, categoryName);
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
