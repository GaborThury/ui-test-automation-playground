import org.junit.jupiter.api.Test;
import org.selenium.helper.ElementHelper;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LoadDelayTest extends SubpageBase {

    public LoadDelayTest() {
        super("Load Delay");
    }

    @Test
    void loadDelayTest() {
        assertDoesNotThrow(() -> ElementHelper.getButtonByText(driver, "Button Appearing After Delay"));
    }
}
