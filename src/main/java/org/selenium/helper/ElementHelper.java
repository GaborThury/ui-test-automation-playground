package org.selenium.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ElementHelper {

    public static WebElement findElementOrReturnNull(WebDriver driver, By selector) {
        try {
            return driver.findElement(selector);
        } catch (Exception e) {
            return null;
        }
    }

    public static WebElement getByText(WebDriver driver, String text) {
        return driver.findElement(By.xpath("//*[text()='" + text + "']"));
    }

    public static WebElement getByPartialText(WebDriver driver, String text) {
        return driver.findElement(By.xpath("//*[contains(text(),'" + text + "')]"));
    }

    public static List<WebElement> getAllByText(WebDriver driver, String text) {
        return driver.findElements(By.xpath("//*[text()='" + text + "']"));
    }

    public static WebElement getButtonByText(WebDriver driver, String text) {
        return driver.findElement(getButtonSelectorByText(text));
    }

    public static By getButtonSelectorByText(String text) {
        return By.xpath("//button[text()='" + text + "']");
    }

    public static WebElement getButtonByPartialText(WebDriver driver, String text) {
        return driver.findElement(By.xpath("//button[contains(text(),'" + text + "')]"));
    }

    public static By getXpathSelectorByText(String text) {
        return By.xpath("//*[text()='" + text + "']");
    }

    public static void waitTillVisible(WebDriver driver, By elementToBeVisible) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementToBeVisible));
    }

    public static void scrollElementIntoFullView(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center', inline: 'center'});",
                element
        );
    }

    public static boolean isElementVisibleInContainer(WebDriver driver, WebElement container, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (Boolean) js.executeScript(
                """
                        const elRect = arguments[1].getBoundingClientRect();\
                        const containerRect = arguments[0].getBoundingClientRect();\
                        return (\
                          elRect.top >= containerRect.top &&\
                          elRect.left >= containerRect.left &&\
                          elRect.bottom <= containerRect.bottom &&\
                          elRect.right <= containerRect.right\
                        );""",
                container, element
        );
    }
}