import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.stream.Stream;

import static org.selenium.helper.ElementHelper.isAlertPresent;

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


}
