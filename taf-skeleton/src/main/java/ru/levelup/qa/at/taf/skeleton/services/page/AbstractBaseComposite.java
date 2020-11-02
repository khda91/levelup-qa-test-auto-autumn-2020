package ru.levelup.qa.at.taf.skeleton.services.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.levelup.qa.at.taf.skeleton.config.TestConfigurationProvider;


public abstract class AbstractBaseComposite {

    protected WebDriver driver;

    protected WebDriverWait webDriverWait;

    protected AbstractBaseComposite(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, TestConfigurationProvider.getTestConfiguration().getWebDriverTimeout());
        PageFactory.initElements(driver, this);
    }
}
