package ru.levelup.qa.at.multithreading;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelup.qa.at.allure.Steps;

public class AllureExampleTest {

    protected ThreadLocal<WebDriver> driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        driver = new ThreadLocal<>();
        driver.set(new ChromeDriver());
//        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.get().quit();
    }

    @DataProvider(parallel = true)
    public Object[][] dataSets() {
        return new Object[][] {
                {"Компьютеры", "Ноутбуки"},
                {"Бытовая техника", "Холодильники"},
                {"Мебель", "Компьютерные кресла"}
        };
    }

    @Test(dataProvider = "dataSets", threadPoolSize = 3, invocationCount = 2)
    public void scriptingTest(String category, String subcategory) {
        Steps step = new Steps(driver.get());

        // 1. Открыть Яндекс маркет
        step.openYandexMarketHomePage();

        // 2. Выбрать категорию "Компьютеры"
        // 3. Выбрать подкатегорию "Ноутбуки"
        step.selectProductCategory(category, subcategory);

        // 4. Добавить первый товар к сравнению
        // 5. добавить второй товар к сравнению
        // 6. Нажать на кнопку сравнить товары
        step.addProductsToCompareAndCompare(1, 2, 3);

        //7. Проверить, что выбранные товары были добавлены к ставнению
        step.checkAddedToCompareProducts();
    }

}
