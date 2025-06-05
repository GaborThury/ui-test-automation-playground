import org.junit.jupiter.api.Test;
import org.selenium.helper.ElementHelper;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.selenium.helper.ElementHelper.waitTillVisible;


public class AjaxDataTest extends SubpageBase {

    public AjaxDataTest() {
        super("AJAX Data");
    }

    @Test
    public void ajaxDataTest() {
        ElementHelper.getButtonByText(driver, "Button Triggering AJAX Request").click();

        assertDoesNotThrow(() -> waitTillVisible(driver, ElementHelper.getXpathSelectorByText("Data loaded with AJAX get request.")));
    }
}
