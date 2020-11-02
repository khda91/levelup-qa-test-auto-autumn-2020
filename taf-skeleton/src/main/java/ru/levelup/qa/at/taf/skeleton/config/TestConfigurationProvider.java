package ru.levelup.qa.at.taf.skeleton.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Properties;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class TestConfigurationProvider {

    private static TestConfiguration testConfiguration;

    public static TestConfiguration getTestConfiguration() {
        String confName = System.getProperty("TESTING_ENV") == null ? "dev" : System.getProperty("TESTING_ENV");
        if (testConfiguration == null) {
            Properties properties = new Properties();
            try {
                properties.load(TestConfigurationProvider.class.getResourceAsStream(confName));
                testConfiguration = new TestConfiguration()
                        .setUrl(properties.getProperty("site.url"))
                        .setWebDriverTimeout(Long.parseLong(properties.getProperty("web.driver.timeout")));
            } catch (IOException e) {
                log.debug(String.format("Неудалось загрузить файл '%s'", confName), e);
            }
        }
        return testConfiguration;
    }

}
