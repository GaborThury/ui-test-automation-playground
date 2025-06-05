import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

// bugs in this feature:
// filesize is not validated
// file extension is not validated
// UI visually is broken

public class FileUploadTest extends SubpageBase {

    public FileUploadTest() {
        super("File Upload");
    }

    private static Stream<Arguments> fileUploadTestData() {
        return Stream.of(
                Arguments.of(
                        new File("src/test/resources/testFileForFileUploadTest.txt").getAbsolutePath(),
                        "1 file(s) selected"),
                Arguments.of(
                        new File("src/test/resources/testFileForFileUploadTest.txt").getAbsolutePath() + "\n" +
                        new File("src/test/resources/testFileForFileUploadTest2.txt").getAbsolutePath(),
                        "2 file(s) selected"),
                Arguments.of(
                        new File("src/test/resources/testFileForFileUploadTest.txt").getAbsolutePath() + "\n" +
                        new File("src/test/resources/testFileForFileUploadTest2.txt").getAbsolutePath() + "\n" +
                        new File("src/test/resources/testFileForFileUploadTest3.txt").getAbsolutePath(),
                        "3 file(s) selected")
        );
    }

    @ParameterizedTest
    @MethodSource(value = "fileUploadTestData")
    void fileUploadTest(String concatenatedFilePaths, String expectedMessage) {
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/section/div/iframe")));
        WebElement fileInput = driver.findElement(By.id("browse"));

        fileInput.sendKeys(concatenatedFilePaths);

        WebElement successMessage = driver.findElement(By.xpath("//p[contains(.,'" + "file(s) selected" + "')]"));
        assertEquals(expectedMessage, successMessage.getText());
    }
}
