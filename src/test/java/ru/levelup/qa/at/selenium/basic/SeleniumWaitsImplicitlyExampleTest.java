package ru.levelup.qa.at.selenium.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.levelup.qa.at.selenium.AbstractBaseTest;
import ru.levelup.qa.at.utils.Utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class SeleniumWaitsImplicitlyExampleTest extends AbstractBaseTest {

    @Test
    public void implicitWaitTest1() {
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        driver.navigate().to("https://market.yandex.ru/");

        WebElement catalogButton = driver.findElement(By.cssSelector("[data-apiary-widget-id='/header/catalogEntrypoint']"));
        catalogButton.click();

        List<WebElement> catalogMainItems = driver.findElements(By.cssSelector("[data-zone-name='category-link']"));
        assertThat(catalogMainItems.size(), greaterThan(6));

        Utils.sleepMillis(2000);
    }

    @Test
    public void implicitWaitFailedTest() {
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        driver.navigate().to("https://market.yandex.ru/");

        long startTime = System.currentTimeMillis();
        WebElement catalogButton;
        try {
            catalogButton = driver.findElement(By.cssSelector("[data-apiary-widget-id='/header/catalogEntrypoint1']"));
        } finally {
            long endTime = (System.currentTimeMillis() - startTime) / 1000;
            System.out.println("End time " + endTime);
        }
        catalogButton.click();

        List<WebElement> catalogMainItems = driver.findElements(By.cssSelector("[data-zone-name='category-link']"));
        assertThat(catalogMainItems.size(), greaterThan(6));

        Utils.sleepMillis(2000);
    }

}
