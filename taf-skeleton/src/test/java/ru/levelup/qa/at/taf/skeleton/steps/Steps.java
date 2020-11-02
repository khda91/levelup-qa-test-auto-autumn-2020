package ru.levelup.qa.at.taf.skeleton.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.levelup.qa.at.taf.skeleton.model.MenuCategory;
import ru.levelup.qa.at.taf.skeleton.services.driver.DriverSingleton;
import ru.levelup.qa.at.taf.skeleton.services.page.YandexMarketCategoryPage;
import ru.levelup.qa.at.taf.skeleton.services.page.YandexMarketCategoryProductPage;
import ru.levelup.qa.at.taf.skeleton.services.page.YandexMarketCompareProductPage;
import ru.levelup.qa.at.taf.skeleton.services.page.YandexMarketHomePage;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Steps {

    List<String> selectedProductNames = new ArrayList<>();
    private YandexMarketHomePage homePage;
    private YandexMarketCategoryPage categoryPage;
    private YandexMarketCategoryProductPage categoryProductPage;
    private YandexMarketCompareProductPage compareProductPage;

    public Steps() {
        WebDriver driver = DriverSingleton.getDriver();
        homePage = new YandexMarketHomePage(driver);
        categoryPage = new YandexMarketCategoryPage(driver);
        categoryProductPage = new YandexMarketCategoryProductPage(driver);
        compareProductPage = new YandexMarketCompareProductPage(driver);
    }

    @Step("Открыть домашнюю страницу Яндекс Маркет")
    public void openYandexMarketHomePage() {
        homePage.open();
    }

    @Step("Выбрать категорию \'{0}\' и подкатегорию \'{1}\'")
    public void selectProductCategory(MenuCategory menuCategory) {
        homePage.selectProductCategory(menuCategory.getCategoryName());
        categoryPage.selectSubCategory(menuCategory.getSubCategoryName());
    }

    @Step("Добавить к сравнению продукты с номером: {0}")
    public void addProductsToCompareAndCompare(int... productNumbers) {
        for (int productNumber : productNumbers) {
            String productName = categoryProductPage.addProductToCompare(productNumber);
            selectedProductNames.add(productName);
        }
        categoryProductPage.clickCompareButton();
    }

    @Step("Проверить, что выбранные продукты добавлены к сравнению")
    public void checkAddedToCompareProducts() {
        List<String> comparedProductNames = compareProductPage.getComparedProductNames();
        assertThat(comparedProductNames)
                .describedAs("Нет добавленных продуктов к сравнению")
                .containsExactlyInAnyOrderElementsOf(selectedProductNames);
    }

}
