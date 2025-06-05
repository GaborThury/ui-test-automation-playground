import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selenium.helper.ElementHelper;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OverlappedElementTest extends SubpageBase {
    public OverlappedElementTest() {
        super("Overlapped Element");
    }

    @Test
    void overLappedElementTest() {
        WebElement nameInput = driver.findElement(By.id("name"));
        ElementHelper.scrollElementIntoFullView(driver, nameInput);
        String testName = "testName";
        nameInput.sendKeys(testName);

        assertEquals(testName, nameInput.getDomProperty("value"));
    }
}
