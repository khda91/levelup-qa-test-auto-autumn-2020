package ru.levelup.qa.at.taf.skeleton.services.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverFactory {

    private WebDriverFactory() {
    }

    public static WebDriver createWebDriver(Browser browser) {
        WebDriver driver;
        switch (browser) {
            case FIREFOX:
                driver = createFireFox();
                break;
            case IE:
                driver = createIE();
                break;
            default:
                driver = createChrome();
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver createChrome() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private static WebDriver createIE() {
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver();
    }

    private static WebDriver createFireFox() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }


}
