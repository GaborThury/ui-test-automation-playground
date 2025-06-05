import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClassAttributeTest extends SubpageBase {

    public ClassAttributeTest() {
        super("Class Attribute");
    }

    @Test
    void classAttributeTest() {
        WebElement pageHeader = driver.findElement(By.xpath("//h3[text()='Class Attribute']"));
        driver.findElement(By.className("btn-primary")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        assertTrue(pageHeader.isDisplayed());
    }
}
