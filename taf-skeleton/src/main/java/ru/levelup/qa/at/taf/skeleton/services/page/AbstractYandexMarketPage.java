package ru.levelup.qa.at.taf.skeleton.services.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public abstract class AbstractYandexMarketPage extends AbstractBaseComposite {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractYandexMarketPage.class);

    @FindBy(css = "[data-zone-name='category-link']")
    private List<WebElement> categoryList;

    protected AbstractYandexMarketPage(WebDriver driver) {
        super(driver);
    }

    public void selectProductCategory(String categoryName) {
        LOGGER.info(String.format("Выбираем категорию '%s'", categoryName));
        clickToElementFromListByText(categoryList, categoryName);
    }

    protected void clickToElementFromListByText(final List<WebElement> elements, final String text) {
        Optional<WebElement> element = elements
                .stream()
                .filter(we -> text.equals(we.getText()))
                .findFirst();
        if (element.isPresent()) {
            element.get().click();
        } else {
            LOGGER.error(String.format("Не удалось найти элемент с текстом '%s'", text));
        }
    }
}
