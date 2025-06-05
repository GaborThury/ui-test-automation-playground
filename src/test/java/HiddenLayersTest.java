import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class HiddenLayersTest extends SubpageBase {

    public HiddenLayersTest() {
        super("Hidden Layers");
    }

    @Test
    void hiddenLayersTest() {
        assertThrows(ElementClickInterceptedException.class, () -> {
            driver.findElement(By.id("greenButton")).click();
            driver.findElement(By.id("greenButton")).click();
        });
    }
}
