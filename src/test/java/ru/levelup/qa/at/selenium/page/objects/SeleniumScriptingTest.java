package ru.levelup.qa.at.selenium.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import ru.levelup.qa.at.selenium.AbstractBaseTest;

public class SeleniumScriptingTest extends AbstractBaseTest {

    @Test
    public void scriptingTest() {
        driver.navigate().to("https://market.yandex.ru/");
        WebDriverWait wait = new WebDriverWait(driver, 5);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Компьютеры')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Ноутбуки"))).click();


    }
}
