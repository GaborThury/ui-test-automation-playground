import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DisabledInputTest extends SubpageBase {

    public DisabledInputTest() {
        super("Disabled Input");
    }

    @Test
    public void testDisabledInput() {
        WebElement inputField = driver.findElement(By.id("inputField"));
        WebElement enableButton = driver.findElement(By.id("enableButton"));
        WebElement feedbackMessage = driver.findElement(By.id("opstatus"));

        enableButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(inputField, "disabled", "true")));

        inputField.sendKeys("someTestInput");
        inputField.sendKeys(Keys.TAB);
        assertEquals("Value changed to: someTestInput", feedbackMessage.getText());
    }
}
