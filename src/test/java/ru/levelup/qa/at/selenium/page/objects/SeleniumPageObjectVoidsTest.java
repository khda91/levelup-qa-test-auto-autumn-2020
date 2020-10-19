package ru.levelup.qa.at.selenium.page.objects;

import org.testng.annotations.Test;
import ru.levelup.qa.at.selenium.AbstractBaseTest;
import ru.levelup.qa.at.selenium.page.objects.voids.YandexMarketCategoryPage;
import ru.levelup.qa.at.selenium.page.objects.voids.YandexMarketCategoryProductPage;
import ru.levelup.qa.at.selenium.page.objects.voids.YandexMarketCompareProductPage;
import ru.levelup.qa.at.selenium.page.objects.voids.YandexMarketHomePage;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class SeleniumPageObjectVoidsTest extends AbstractBaseTest {

    @Test
    public void scriptingTest() {
        // 1. Открыть Яндекс маркет
        YandexMarketHomePage homePage = new YandexMarketHomePage(driver);
        homePage.open();

        // 2. Выбрать категорию "Компьютеры"
        homePage.selectProductCategory("Компьютеры");

        YandexMarketCategoryPage categoryPage = new YandexMarketCategoryPage(driver);

        // 3. Выбрать подкатегорию "Ноутбуки"
        categoryPage.selectSubCategory("Ноутбуки");

        YandexMarketCategoryProductPage categoryProductPage = new YandexMarketCategoryProductPage(driver);

        // 4. Добавить первый товар к сравнению
        List<String> selectedProductNames = new ArrayList<>();
        String productName = categoryProductPage.addProductToCompare(1);
        selectedProductNames.add(productName);

        // 5. добавить второй товар к сравнению
        productName = categoryProductPage.addProductToCompare(2);
        selectedProductNames.add(productName);

        // 6. Нажать на кнопку сравнить товары
        categoryProductPage.clickCompareButton();

        YandexMarketCompareProductPage compareProductPage = new YandexMarketCompareProductPage(driver);

        //7. Проверить, что выбранные товары были добавлены к ставнению
        List<String> comparedProductNames = compareProductPage.getComparedProductNames();

        assertThat(comparedProductNames, containsInAnyOrder(selectedProductNames.toArray(new String[selectedProductNames.size()])));
    }

}
