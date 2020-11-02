package ru.levelup.qa.at.taf.skeleton.config;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TestConfiguration {

    private String url;
    private long webDriverTimeout;
}
