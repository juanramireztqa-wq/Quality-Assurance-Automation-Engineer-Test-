package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * This class contains hooks for setting up and tearing down the WebDriver before and after each test scenario.
 * The @Before method initializes the WebDriver with specific Chrome options to disable password manager warnings and
 * the @After method ensures that the WebDriver is properly closed after each test scenario to prevent resource leaks.
 */
public class Hooks {
    public static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        // Configure Chrome options to disable password manager warnings and prompts
        final Map<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        chromePrefs.put("profile.password_manager_leak_detection", false);

        final ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", chromePrefs);
        chromeOptions.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        try {
            if (driver != null) {
                driver.quit();
                driver = null;
            }
        } catch (Exception e) {
            System.out.println("Error closing browser: " + e.getMessage());
        }
    }

}
