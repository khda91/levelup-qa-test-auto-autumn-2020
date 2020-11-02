package ru.levelup.qa.at.taf.skeleton;

import org.testng.annotations.Test;
import ru.levelup.qa.at.taf.skeleton.model.MenuCategory;
import ru.levelup.qa.at.taf.skeleton.steps.Steps;

public class Selenium1Test extends AbstractBaseTest {

    @Test
    public void test() {
        Steps step = new Steps();

        // 1. Открыть Яндекс маркет
        step.openYandexMarketHomePage();

        // 2. Выбрать категорию "Компьютеры"
        // 3. Выбрать подкатегорию "Ноутбуки"
        step.selectProductCategory(new MenuCategory("Компьютеры", "Ноутбуки"));

        // 4. Добавить первый товар к сравнению
        // 5. добавить второй товар к сравнению
        // 6. Нажать на кнопку сравнить товары
        step.addProductsToCompareAndCompare(1, 2, 3);

        //7. Проверить, что выбранные товары были добавлены к ставнению
        step.checkAddedToCompareProducts();
    }

}
