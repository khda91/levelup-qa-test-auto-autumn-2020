package ru.levelup.qa.at.selenium.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import ru.levelup.qa.at.selenium.AbstractBaseTest;
import ru.levelup.qa.at.utils.Utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class SeleniumWaitsExplicitlyVsImplicitlyExampleTest extends AbstractBaseTest {

    @Test
    public void explicitVsImplicitWaitTest1() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
    public void explicitVsImplicitWaitTest2() {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
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
    public void explicitVsImplicitWaitTest3() {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.navigate().to("https://market.yandex.ru/");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        long startTime = System.currentTimeMillis();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebElement catalogButton;
        try {
            catalogButton = wait.until(ExpectedConditions.
                    elementToBeClickable(By
                            .cssSelector("[data-apiary-widget-id='/header/catalogEntrypoint1']")));
        } finally {
            long endTime = (System.currentTimeMillis() - startTime);
            System.out.println("End time " + endTime);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }
        catalogButton.click();

        List<WebElement> catalogMainItems = wait.until(ExpectedConditions
                .numberOfElementsToBeMoreThan(By
                        .cssSelector("[data-zone-name='category-link']"), 3));

        assertThat(catalogMainItems.size(), greaterThan(6));

        Utils.sleepMillis(2000);
    }

}
