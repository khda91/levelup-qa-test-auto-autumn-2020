package ru.levelup.qa.at.selenium.page.objects.page.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractBaseComposite {

    protected WebDriver driver;

    protected WebDriverWait webDriverWait;

    protected AbstractBaseComposite(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }
}
