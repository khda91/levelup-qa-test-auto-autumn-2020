package ru.levelup.qa.at.design.patterns.factory.method;

public enum Browser {

    CHROME("chrome"),
    FIREFOX("firefox"),
    IE("IE");

    private String browserName;

    Browser(String browserName) {
        this.browserName = browserName;
    }

    public static Browser getBrowser(String browserName) {
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
