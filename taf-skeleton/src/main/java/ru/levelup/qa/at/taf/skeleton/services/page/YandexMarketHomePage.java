package ru.levelup.qa.at.taf.skeleton.services.page;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import ru.levelup.qa.at.taf.skeleton.config.TestConfigurationProvider;

@Slf4j
public class YandexMarketHomePage extends AbstractYandexMarketPage {

    private static final String HOME_PAGE_URL = TestConfigurationProvider.getTestConfiguration().getUrl();

    public YandexMarketHomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        log.info("Открыть домашнюю страницу Яндекс.Маркет");
        driver.navigate().to(HOME_PAGE_URL);
    }
}
