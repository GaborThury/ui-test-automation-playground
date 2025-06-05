import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimatedButtonTest extends SubpageBase {

    public AnimatedButtonTest() {
        super("Animated Button");
    }

    @Test
    void animatedButtonTest() {
        WebElement startAnimation = driver.findElement(By.id("animationButton"));
        WebElement movingTargetButton = driver.findElement(By.id("movingTarget"));

        startAnimation.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(movingTargetButton, "class", "spin")));
        movingTargetButton.click();
        assertEquals("Moving Target clicked. It's class name is 'btn btn-primary'", driver.findElement(By.id("opstatus")).getText());
    }
}
