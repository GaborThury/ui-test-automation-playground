import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selenium.helper.ElementHelper;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VisibilityTest extends SubpageBase {
    public VisibilityTest() {
        super("Visibility");
    }

    @Test
    void visibilityTest() {
        WebElement hideButton = ElementHelper.getButtonByText(driver, "Hide");
        List<By> selectorsToCheck = List.of(
                ElementHelper.getButtonSelectorByText("Removed"),
                ElementHelper.getButtonSelectorByText("Zero Width"),
                ElementHelper.getButtonSelectorByText("Overlapped"),
                ElementHelper.getButtonSelectorByText("Opacity 0"),
                ElementHelper.getButtonSelectorByText("Visibility Hidden"),
                ElementHelper.getButtonSelectorByText("Display None"),
                ElementHelper.getButtonSelectorByText("Offscreen")
        );

        assertTrue(selectorsToCheck
                .stream()
                .allMatch(selector -> driver.findElement(selector).isDisplayed())
        );

        hideButton.click();
        assertFalse(selectorsToCheck
                .stream()
                .map(selector -> ElementHelper.findElementOrReturnNull(driver, selector))
                .filter(Objects::nonNull)
                .allMatch(WebElement::isDisplayed)
        );
    }
}
