import org.junit.jupiter.api.Test;
import org.selenium.helper.ElementHelper;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class NonBreakingSpaceTest extends SubpageBase {
    public NonBreakingSpaceTest() {
        super("Non-Breaking Space");
    }

    @Test
    void nonBreakingSpaceTest() {
        assertDoesNotThrow(() -> ElementHelper.getButtonByText(driver, "My\u00A0Button").click());
    }
}
