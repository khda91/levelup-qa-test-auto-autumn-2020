package ru.levelup.qa.at.selenium.page.objects;

import org.testng.annotations.Test;
import ru.levelup.qa.at.selenium.AbstractBaseTest;
import ru.levelup.qa.at.selenium.page.objects.steps.Steps;

public class SeleniumPageObjectStepDesignPatternTest extends AbstractBaseTest {

    @Test
    public void scriptingTest() {
        Steps step = new Steps(driver);

        // 1. Открыть Яндекс маркет
        step.openYandexMarketHomePage();

        // 2. Выбрать категорию "Компьютеры"
        // 3. Выбрать подкатегорию "Ноутбуки"
        step.selectProductCategory("Компьютеры", "Ноутбуки");

        // 4. Добавить первый товар к сравнению
        // 5. добавить второй товар к сравнению
        // 6. Нажать на кнопку сравнить товары
        step.addProductsToCompareAndCompare(1, 2, 3);

        //7. Проверить, что выбранные товары были добавлены к ставнению
        step.checkAddedToCompareProducts();
    }

}
