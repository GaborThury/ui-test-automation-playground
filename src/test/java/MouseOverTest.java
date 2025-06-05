import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.selenium.helper.ElementHelper;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MouseOverTest extends SubpageBase {
    public MouseOverTest() {
        super("Mouse Over");
    }

    @Test
    void mouseOverTest() {
        Actions actions = new Actions(driver);
        actions
                .moveToElement((ElementHelper.getByText(driver, "Click me")))
                .click()
                .click()
                .moveToElement((ElementHelper.getByText(driver, "Link Button")))
                .click()
                .click()
                .perform();

        assertEquals("The link above clicked 2 times.", driver.findElement(By.xpath("/html/body/section/div/div[2]/p")).getText());
        assertEquals("The link above clicked 2 times.", driver.findElement(By.xpath("/html/body/section/div/div[4]/p")).getText());
    }
}
