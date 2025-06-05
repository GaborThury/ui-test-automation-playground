import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShadowDomTest extends SubpageBase {
    public ShadowDomTest() {
        super("Shadow DOM");
    }

    @Disabled("the copy button is broken on the website")
    @Test
    void shadowDomTest() throws IOException, UnsupportedFlavorException {
        SearchContext shadowRoot = driver.findElement(By.xpath("//guid-generator")).getShadowRoot();
        WebElement generateGuidButton = shadowRoot.findElement(By.id("buttonGenerate"));
        WebElement copyButton = shadowRoot.findElement(By.id("buttonCopy"));
        WebElement inputField = shadowRoot.findElement(By.id("editField"));

        generateGuidButton.click();
        copyButton.click();
        String guidFromClipboard = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        String guidFromInputField = inputField.getDomProperty("value");

        assertEquals(guidFromClipboard, guidFromInputField);
    }
}
