package ru.levelup.qa.at.taf.skeleton.services.driver;

public enum Browser {

    CHROME("chrome"),
    FIREFOX("firefox"),
    IE("IE");

    private String browserName;

    Browser(String browserName) {
        this.browserName = browserName;
    }

    public static Browser getBrowser(String browserName) {
        if (browserName == null || browserName.isEmpty()) {
            return CHROME;
        }
        for (Browser value : values()) {
            if (value.getBrowserName().equalsIgnoreCase(browserName)) {
                return value;
            }
        }
        throw new IllegalArgumentException(String.format("Browser '%s' was not found", browserName));
    }

    public String getBrowserName() {
        return browserName;
    }
}
