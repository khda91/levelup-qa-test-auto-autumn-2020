package ru.levelup.qa.at.selenium.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import ru.levelup.qa.at.selenium.AbstractBaseTest;
import ru.levelup.qa.at.utils.Utils;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class SeleniumWaitsExplicitlyExampleTest extends AbstractBaseTest {

    @Test
    public void explicitWaitTest1() {
        driver.navigate().to("https://market.yandex.ru/");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement catalogButton = wait.until(ExpectedConditions.
                elementToBeClickable(By
                        .cssSelector("[data-apiary-widget-id='/header/catalogEntrypoint']")));
        catalogButton.click();

        List<WebElement> catalogMainItems = wait.until(ExpectedConditions
                .numberOfElementsToBeMoreThan(By
                        .cssSelector("[data-zone-name='category-link']"), 3));

        assertThat(catalogMainItems.size(), greaterThan(6));

        Utils.sleepMillis(2000);
    }

    @Test
    public void explicitWaitFailedTest() {
        driver.navigate().to("https://market.yandex.ru/");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        long startTime = System.currentTimeMillis();
        WebElement catalogButton;
        try {
            catalogButton = wait.until(ExpectedConditions.
                    elementToBeClickable(By
                            .cssSelector("[data-apiary-widget-id='/header/catalogEntrypoint1']")));
        } finally {
            long endTime = (System.currentTimeMillis() - startTime);
            System.out.println("End time " + endTime);
        }
        catalogButton.click();

        List<WebElement> catalogMainItems = wait.until(ExpectedConditions
                .numberOfElementsToBeMoreThan(By
                        .cssSelector("[data-zone-name='category-link']"), 3));

        assertThat(catalogMainItems.size(), greaterThan(6));

        Utils.sleepMillis(2000);
    }

    @Test
    public void explicitWaitWithIntervalFailedTest() {
        driver.navigate().to("https://market.yandex.ru/");

        WebDriverWait wait = new WebDriverWait(driver, 10, 2000);

        long startTime = System.currentTimeMillis();
        WebElement catalogButton;
        try {
            catalogButton = wait.until(ExpectedConditions.
                    elementToBeClickable(By
                            .cssSelector("[data-apiary-widget-id='/header/catalogEntrypoint1']")));
        } finally {
            long endTime = (System.currentTimeMillis() - startTime);
            System.out.println("End time " + endTime);
        }
        catalogButton.click();

        List<WebElement> catalogMainItems = wait.until(ExpectedConditions
                .numberOfElementsToBeMoreThan(By
                        .cssSelector("[data-zone-name='category-link']"), 3));

        assertThat(catalogMainItems.size(), greaterThan(6));

        Utils.sleepMillis(2000);
    }

    @Test
    public void customExplicitWaitFailedTest() {
        driver.navigate().to("https://market.yandex.ru/");

        WebDriverWait wait = new WebDriverWait(driver, 10, 2000);

        WebElement catalogButton = wait.until(ExpectedConditions.
                    elementToBeClickable(By
                            .cssSelector("[data-apiary-widget-id='/header/catalogEntrypoint']")));
        catalogButton.click();

        new WebDriverWait(driver, 3)
                .until(new ExpectedCondition<Boolean>() {

                    @Override
                    public Boolean apply(WebDriver driver) {
                        return driver.findElement(By.className("_3-oCj6-zhb")).isDisplayed();
                    }
                });

        List<WebElement> catalogMainItems = wait.until(ExpectedConditions
                .numberOfElementsToBeMoreThan(By
                        .cssSelector("[data-zone-name='category-link']"), 3));

        assertThat(catalogMainItems.size(), greaterThan(6));

        Utils.sleepMillis(2000);
    }

}
