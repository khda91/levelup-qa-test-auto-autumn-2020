package ru.levelup.qa.at.selenium.page.objects.statics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class YandexMarketCompareProductPage {

    private static WebDriver driver;

    public static void init(WebDriver webDriver) {
        driver = webDriver;
    }

    public static List<String> getComparedProductNames() {
        return new WebDriverWait(driver, 5)
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".LwwocgVx0q.zvRJMhRW-w"), 1))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
