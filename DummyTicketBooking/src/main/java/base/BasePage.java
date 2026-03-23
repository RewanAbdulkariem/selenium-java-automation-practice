package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    protected WebElement find(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        new Actions(driver).scrollToElement(element).perform();
        return element;
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(find(locator))).click();
    }
    public void click(By locator, int index) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator))
                .get(index)
                .click();
    }
    public void type(By locator, String text) {
        WebElement element = find(locator);
        element.clear();
        element.sendKeys(text);
    }
    public String getText(By locator) {
        return find(locator).getText();
    }

    public void selectByText(By locator, String text) {
        new Select(find(locator)).selectByVisibleText(text);
    }

    public void selectByValue(By locator, String value) {
        new Select(find(locator)).selectByValue(value);
    }
    public void switchToFrame(By frameLocator) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
    }
    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
}
