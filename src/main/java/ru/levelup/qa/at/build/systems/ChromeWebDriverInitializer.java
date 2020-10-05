package ru.levelup.qa.at.build.systems;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeWebDriverInitializer {

    public WebDriver init() {
        return new ChromeDriver();
    }
}
