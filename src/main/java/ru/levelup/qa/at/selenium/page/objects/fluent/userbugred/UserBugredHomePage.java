package ru.levelup.qa.at.selenium.page.objects.fluent.userbugred;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserBugredHomePage {

    private WebDriver driver;

    @FindBy(xpath = "//a//span[text()='Войти']")
    private WebElement enterButton;

    @FindBy(css = ".dropdown-toggle")
    private WebElement userButton;

    public UserBugredHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public UssrBugredLoginRegistrationPage enterButtonClick() {
        enterButton.click();
        return new UssrBugredLoginRegistrationPage(driver);
    }

    public boolean isUserButtonDisplayed() {
        return new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(userButton)).isDisplayed();
    }

    public String getUserButtonText() {
        return userButton.getText();
    }
}
