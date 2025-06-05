import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SampleAppTest extends SubpageBase {
    public SampleAppTest() {
        super("Sample App");
    }

    @Test
    void sampleAppTest() {
        WebElement userName = driver.findElement(By.name("UserName"));
        WebElement password = driver.findElement(By.name("Password"));
        WebElement loginButton = driver.findElement(By.id("login"));
        String loginName = "cat";

        userName.sendKeys(loginName);
        password.sendKeys("pwd");
        loginButton.click();

        assertEquals(String.format("Welcome, %s!", loginName), driver.findElement(By.id("loginstatus")).getText());
    }
}
