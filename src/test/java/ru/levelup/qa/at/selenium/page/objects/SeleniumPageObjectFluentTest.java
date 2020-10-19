package ru.levelup.qa.at.selenium.page.objects;

import org.testng.annotations.Test;
import ru.levelup.qa.at.selenium.AbstractBaseTest;
import ru.levelup.qa.at.selenium.page.objects.basic.YandexMarketCategoryProductPage;
import ru.levelup.qa.at.selenium.page.objects.basic.YandexMarketHomePage;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class SeleniumPageObjectFluentTest extends AbstractBaseTest {

    @Test
    public void scriptingTest() {
        List<String> selectedProductNames = new ArrayList<>();

        YandexMarketCategoryProductPage categoryProductPage = new YandexMarketHomePage(driver).open()   // 1. Открыть Яндекс маркет
                .selectProductCategory("Компьютеры")                                        // 2. Выбрать категорию "Компьютеры"
                .selectSubCategory("Ноутбуки");                                          // 3. Выбрать подкатегорию "Ноутбуки"

        selectedProductNames.add(categoryProductPage.addProductToCompare(1));              // 4. Добавить первый товар к сравнению
        selectedProductNames.add(categoryProductPage.addProductToCompare(2));              // 5. добавить второй товар к сравнению

        List<String> comparedProductNames = categoryProductPage.clickCompareButton()                    // 6. Нажать на кнопку сравнить товары
                .getComparedProductNames();                                                             // 7. Проверить, что выбранные товары были добавлены к ставнению

        assertThat(comparedProductNames, containsInAnyOrder(selectedProductNames.toArray(new String[selectedProductNames.size()])));
    }

}
