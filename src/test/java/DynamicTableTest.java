import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selenium.helper.ElementHelper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DynamicTableTest extends SubpageBase {
    public DynamicTableTest() {
        super("Dynamic Table");
    }

    @Test
    void dynamicTableTest() {
        List<WebElement> headers = driver.findElements(By.xpath("//div[@role='rowgroup'][1]//span[@role='columnheader']"));
        List<WebElement> rows = driver.findElements(By.xpath("//div[@role='rowgroup'][2]//div[@role='row']"));
        int cpuIndex = getCpuColumnIndex(headers);
        String chromeCpuLoadPercentage = getCpuLoadPercentage(rows, cpuIndex);

        String chromeCpuUsageText = ElementHelper.getByPartialText(driver, "Chrome CPU").getText();

        assertFalse(chromeCpuUsageText.isBlank());
        assertTrue(chromeCpuUsageText.contains(chromeCpuLoadPercentage));
    }

    private int getCpuColumnIndex(List<WebElement> headers) {
        for (int i = 0; i < headers.size(); i++) {
            if ("CPU".equalsIgnoreCase(headers.get(i).getText())) {
                return i;
            }
        }
        return 0;
    }

    private String getCpuLoadPercentage(List<WebElement> rows, int cpuIndex) {
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.xpath(".//span[@role='cell']"));
            if ("Chrome".equalsIgnoreCase(cells.getFirst().getText().trim())) {
                return cells.get(cpuIndex).getText().trim();
            }
        }
        return "";
    }
}
