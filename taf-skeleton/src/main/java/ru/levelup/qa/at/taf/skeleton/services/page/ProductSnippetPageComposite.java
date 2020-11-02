package ru.levelup.qa.at.taf.skeleton.services.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfNestedElementLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ProductSnippetPageComposite extends AbstractBaseComposite {

    private WebElement root;

    protected ProductSnippetPageComposite(WebDriver driver, WebElement root) {
        super(driver);
        this.root = root;
    }

    public void addToCompare() {
        WebElement addToCompare = webDriverWait.until(presenceOfNestedElementLocatedBy(root,
                xpath(".//div[contains(@aria-label, 'сравнению')]")));
        new Actions(driver)
                .moveToElement(addToCompare)
                .click()
                .build()
                .perform();
    }

    public String getProductName() {
        return webDriverWait.until(visibilityOf(root.findElement(xpath(".//div//child::h3[@data-zone-name='title']")))).getText().trim();
    }
}
