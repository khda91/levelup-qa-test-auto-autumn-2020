package ru.levelup.qa.at.selenium.page.objects;

import org.testng.annotations.Test;
import ru.levelup.qa.at.selenium.AbstractBaseTest;
import ru.levelup.qa.at.selenium.page.objects.statics.YandexMarketCategoryPage;
import ru.levelup.qa.at.selenium.page.objects.statics.YandexMarketCategoryProductPage;
import ru.levelup.qa.at.selenium.page.objects.statics.YandexMarketCompareProductPage;
import ru.levelup.qa.at.selenium.page.objects.statics.YandexMarketHomePage;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class SeleniumPageObjectStaticsTest extends AbstractBaseTest {

    @Test
    public void scriptingTest() {

        // 1. Открыть Яндекс маркет
        YandexMarketHomePage.open(driver);
        YandexMarketCategoryPage.init(driver);
        YandexMarketCategoryProductPage.init(driver);
        YandexMarketCompareProductPage.init(driver);

        // 2. Выбрать категорию "Компьютеры"
        YandexMarketHomePage.selectProductCategory("Компьютеры");

        // 3. Выбрать подкатегорию "Ноутбуки"
        YandexMarketCategoryPage.selectSubCategory("Ноутбуки");

        // 4. Добавить первый товар к сравнению
        List<String> selectedProductNames = new ArrayList<>();
        String productName = YandexMarketCategoryProductPage.addProductToCompare(1);
        selectedProductNames.add(productName);

        // 5. добавить второй товар к сравнению
        productName = YandexMarketCategoryProductPage.addProductToCompare(2);
        selectedProductNames.add(productName);

        // 6. Нажать на кнопку сравнить товары
        YandexMarketCategoryProductPage.clickCompareButton();

        //7. Проверить, что выбранные товары были добавлены к ставнению
        List<String> comparedProductNames = YandexMarketCompareProductPage.getComparedProductNames();

        assertThat(comparedProductNames, containsInAnyOrder(selectedProductNames.toArray(new String[selectedProductNames.size()])));
    }

}
