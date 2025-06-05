import org.junit.jupiter.api.Test;
import org.selenium.helper.ElementHelper;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.selenium.helper.ElementHelper.waitTillVisible;

public class ClientSideDelayTest extends SubpageBase {

    public ClientSideDelayTest() {
        super("Client Side Delay");
    }

    @Test
    public void clientSideDelayTest() {
        ElementHelper.getButtonByText(driver, "Button Triggering Client Side Logic").click();
        assertDoesNotThrow(() -> waitTillVisible(driver, ElementHelper.getXpathSelectorByText("Data calculated on the client side.")));
    }

}
