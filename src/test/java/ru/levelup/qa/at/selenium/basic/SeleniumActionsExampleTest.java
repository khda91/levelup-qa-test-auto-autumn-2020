package ru.levelup.qa.at.selenium.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import ru.levelup.qa.at.selenium.AbstractBaseTest;
import ru.levelup.qa.at.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SeleniumActionsExampleTest extends AbstractBaseTest {

    @Test
    public void actionsBuilderTest() {
        driver.navigate().to("https://market.yandex.ru/");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement catalogButton = wait.until(ExpectedConditions.
                elementToBeClickable(By
                        .cssSelector("[data-apiary-widget-id='/header/catalogEntrypoint']")));
        catalogButton.click();

        List<WebElement> catalogMainItems = wait.until(ExpectedConditions
                .numberOfElementsToBeMoreThan(By
                        .cssSelector("div[role='tablist'] > div[data-zone-name='category-link']"), 3));

        WebElement categoryItem = catalogMainItems
                .stream()
                .filter(item -> "Компьютерная техника".equals(item.getText()))
                .findFirst()
                .get();

        Actions actions = new Actions(driver);
        actions
//                .moveToElement(categoryItem)
                .moveToElement(wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By
                                .xpath("//div[@role='tablist']/div[@data-zone-name='category-link']//span[text()='Компьютерная техника']"))))
                .click(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Ноутбуки и планшеты']"))))
                .build()
                .perform();

        Utils.sleepMillis(2000);

        assertThat(driver.getTitle(), equalTo("Ноутбуки и планшеты — купить на Яндекс.Маркете"));

    }

    @Test
    public void actionsBuilderTest1() {
        driver.navigate().to("https://market.yandex.ru/");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement catalogButton = wait.until(ExpectedConditions.
                elementToBeClickable(By
                        .cssSelector("[data-apiary-widget-id='/header/catalogEntrypoint']")));
        catalogButton.click();

        List<WebElement> catalogMainItems = wait.until(ExpectedConditions
                .numberOfElementsToBeMoreThan(By
                        .cssSelector("div[role='tablist'] > div[data-zone-name='category-link']"), 3));

        WebElement categoryItem = catalogMainItems
                .stream()
                .filter(item -> "Компьютерная техника".equals(item.getText()))
                .findFirst()
                .get();

        Actions actions = new Actions(driver);
        actions
                .moveToElement(categoryItem)
//                .moveToElement(wait.until(ExpectedConditions
//                        .visibilityOfElementLocated(By
//                                .xpath("//div[@role='tablist']/div[@data-zone-name='category-link']//span[text()='Компьютерная техника']"))))
//                .click(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Ноутбуки и планшеты']"))))
                .keyDown(Keys.COMMAND)
                .click()
                .build()
                .perform();

        ArrayList<String> driverHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(driverHandles.get(0));

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Ноутбуки и планшеты']"))).click();

        Utils.sleepMillis(2000);

        assertThat(driver.getTitle(), equalTo("Ноутбуки и планшеты — купить на Яндекс.Маркете"));

    }

}
