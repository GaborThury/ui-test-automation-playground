import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerifyTextTest extends SubpageBase {
    public VerifyTextTest() {
        super("Verify Text");
    }

    @Test
    void verifyTextTest() {
        WebElement welcome = driver.findElement(By.xpath("//span[normalize-space(.)='Welcome UserName!']"));

        assertEquals("Welcome UserName!", welcome.getText());
    }
}
