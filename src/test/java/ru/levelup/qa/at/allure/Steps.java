package ru.levelup.qa.at.allure;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.levelup.qa.at.selenium.page.objects.page.components.YandexMarketCategoryPage;
import ru.levelup.qa.at.selenium.page.objects.page.components.YandexMarketCategoryProductPage;
import ru.levelup.qa.at.selenium.page.objects.page.components.YandexMarketCompareProductPage;
import ru.levelup.qa.at.selenium.page.objects.page.components.YandexMarketHomePage;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class Steps {

    List<String> selectedProductNames = new ArrayList<>();
    private WebDriver driver;
    private YandexMarketHomePage homePage;
    private YandexMarketCategoryPage categoryPage;
    private YandexMarketCategoryProductPage categoryProductPage;
    private YandexMarketCompareProductPage compareProductPage;

    public Steps(WebDriver driver) {
        this.driver = driver;
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
    public void selectProductCategory(String categoryName, String subCategoryName) {
        homePage.selectProductCategory(categoryName);
        categoryPage.selectSubCategory(subCategoryName);
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
        assertThat(comparedProductNames, containsInAnyOrder(selectedProductNames.toArray(new String[selectedProductNames.size()])));
    }

}
