import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.selenium.helper.ElementHelper;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProgressBarTest extends SubpageBase {
    public ProgressBarTest() {
        super("Progress Bar");
    }

    @Test
    void progressBarTest() {
        WebElement startButton = ElementHelper.getButtonByText(driver, "Start");
        WebElement stopButton = ElementHelper.getButtonByPartialText(driver, "Stop");
        WebElement progressBar = driver.findElement(By.id("progressBar"));

        startButton.click();
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(50))
                .ignoring(NoSuchElementException.class);

        wait.until((driver) -> "75".equals(progressBar.getDomAttribute("aria-valuenow")));
        stopButton.click();

        assertEquals("75", progressBar.getDomAttribute("aria-valuenow"));
    }
}
