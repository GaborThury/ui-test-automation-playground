import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextInputTest extends SubpageBase {

    public TextInputTest() {
        super("Text Input");
    }

    @Test
    void textInputTest() {
        String updatedText = "someText";
        WebElement button = driver.findElement(By.id("updatingButton"));

        driver.findElement(By.id("newButtonName")).sendKeys(updatedText);
        button.click();
        String buttonText = button.getText();
        assertEquals(updatedText, buttonText);
    }
}
