package ru.levelup.qa.at.selenium.page.objects;

import org.testng.annotations.Test;
import ru.levelup.qa.at.selenium.AbstractBaseTest;
import ru.levelup.qa.at.selenium.page.objects.basic.YandexMarketCategoryPage;
import ru.levelup.qa.at.selenium.page.objects.basic.YandexMarketCategoryProductPage;
import ru.levelup.qa.at.selenium.page.objects.basic.YandexMarketCompareProductPage;
import ru.levelup.qa.at.selenium.page.objects.basic.YandexMarketHomePage;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class SeleniumPageObjectBasicTest extends AbstractBaseTest {

    @Test
    public void scriptingTest() {

        // 1. Открыть Яндекс маркет
        YandexMarketHomePage homePage = new YandexMarketHomePage(driver);
        homePage.open();

        // 2. Выбрать категорию "Компьютеры"
        YandexMarketCategoryPage categoryPage = homePage.selectProductCategory("Компьютеры");

        // 3. Выбрать подкатегорию "Ноутбуки"
        YandexMarketCategoryProductPage categoryProductPage = categoryPage.selectSubCategory("Ноутбуки");

        // 4. Добавить первый товар к сравнению
        List<String> selectedProductNames = new ArrayList<>();
        String productName = categoryProductPage.addProductToCompare(1);
        selectedProductNames.add(productName);

        // 5. добавить второй товар к сравнению
        productName = categoryProductPage.addProductToCompare(2);
        selectedProductNames.add(productName);

        // 6. Нажать на кнопку сравнить товары
        YandexMarketCompareProductPage compareProductPage = categoryProductPage.clickCompareButton();

        //7. Проверить, что выбранные товары были добавлены к ставнению
        List<String> comparedProductNames = compareProductPage.getComparedProductNames();

        assertThat(comparedProductNames, containsInAnyOrder(selectedProductNames.toArray(new String[selectedProductNames.size()])));
    }

}
