package ru.levelup.qa.at.selenium.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.levelup.qa.at.selenium.AbstractBaseTest;
import ru.levelup.qa.at.utils.Utils;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class SeleniumWaitsBadExampleTest extends AbstractBaseTest {

    @Test
    public void openYandexMarketHomePageXPathClassName() {

        driver.navigate().to("https://market.yandex.ru/");

        Utils.sleepMillis(2000);

        WebElement catalogButton = driver.findElement(By.cssSelector("[data-apiary-widget-id='/header/catalogEntrypoint']"));
        catalogButton.click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> catalogMainItems = driver.findElements(By.cssSelector("[data-zone-name='category-link']"));
        assertThat(catalogMainItems.size(), greaterThan(6));

        Utils.sleepMillis(2000);
    }

}
