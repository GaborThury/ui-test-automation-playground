import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.selenium.helper.config.Config;

import java.util.concurrent.Semaphore;

public abstract class SubpageBase implements Subpage {

    protected WebDriver driver;
    protected final String linkText;
    private static final Semaphore semaphore = new Semaphore(4);

    public SubpageBase(String linkText) {
        this.linkText = linkText;
    }

    @BeforeAll
    static void globalSetup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() throws InterruptedException {
        semaphore.acquire();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");

        driver = new ChromeDriver(options);
        driver.get(Config.get("baseurl"));
        driver.manage().window().maximize();
        driver.findElement(By.linkText(getLinkText())).click();
    }

    @Override
    public String getLinkText() {
        return linkText;
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        semaphore.release();
    }
}
