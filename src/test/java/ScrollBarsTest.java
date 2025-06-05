import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.selenium.helper.ElementHelper.isElementVisibleInContainer;

public class ScrollBarsTest extends SubpageBase {
    public ScrollBarsTest() {
        super("Scrollbars");
    }

    @Test
    void scrollBarsTest() {
        WebElement button = driver.findElement(By.id("hidingButton"));
        WebElement container = driver.findElement(By.cssSelector("div[style*='overflow-y: scroll']"));
        assertFalse(isElementVisibleInContainer(driver, container, button));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", button);

        assertTrue(isElementVisibleInContainer(driver, container, button));
    }
}
