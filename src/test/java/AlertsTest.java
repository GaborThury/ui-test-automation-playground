import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.stream.Stream;

public class AlertsTest extends SubpageBase {

    public AlertsTest() {
        super("Alerts");
    }

    @Test
    void alertTest() {
        WebElement alertButton = driver.findElement(By.id("alertButton"));
        alertButton.click();
        driver.switchTo().alert().accept();
    }

    @Test
    void confirmDismissTest() {
        WebElement confirmButton = driver.findElement(By.id("confirmButton"));
        confirmButton.click();

        while (isAlertPresent(driver)) {
            driver.switchTo().alert().dismiss();
        }
    }

    @Test
    void confirmAcceptTest() {
        WebElement confirmButton = driver.findElement(By.id("confirmButton"));
        confirmButton.click();

        while (isAlertPresent(driver)) {
            driver.switchTo().alert().accept();
        }
    }

    public static Stream<String> promptsTestData() {
        return Stream.of("cats", "dogs", "someInvalidInput");
    }

    @ParameterizedTest
    @MethodSource(value = "promptsTestData")
    void promptTest(String promptInput) {
        WebElement promptButton = driver.findElement(By.id("promptButton"));
        promptButton.click();

        driver.switchTo().alert().sendKeys(promptInput);
        driver.switchTo().alert().accept();

        while (isAlertPresent(driver)) {
            driver.switchTo().alert().accept();
        }
    }

    private boolean isAlertPresent(WebDriver driver) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(4))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoAlertPresentException.class);

        try {
            wait.until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
