import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClickTest extends SubpageBase {

    public ClickTest() {
        super("Click");
    }

    @Test
    public void clickWithJavascriptTest() {
        WebElement button = driver.findElement(By.id("badButton"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        assertFalse(
                Objects.requireNonNull(button.getDomAttribute("class")).contains("btn-success"),
                "For this button, JS based click should NOT work."
        );
    }

    @Test
    void clickPhysicallyTest() {
        WebElement button = driver.findElement(By.id("badButton"));
        Actions actions = new Actions(driver);

        actions.moveToElement(button).click().perform();
        assertTrue(
                Objects.requireNonNull(button.getDomAttribute("class")).contains("btn-success"),
                "For this button, physical click should work."
        );
    }
}
