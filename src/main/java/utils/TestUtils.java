package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.io.File;

public class TestUtils {

    public static WebDriver driver;

    public static WebDriver launchDriver(String browserName) {
        switch (browserName) {
            case "firefox" -> {
                if (!isMac()) {
                    File file = new File("src/main/resources/geckodriver");
                    System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
                }
                driver = new FirefoxDriver();
            }
            case "chrome" -> {
                if (!isMac()) {
                    File file = new File("src/main/resources/chromedriver");
                    System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
                }
                driver = new ChromeDriver();
            }
            case "msedge" -> {
                if (!isMac()) {
                    File file = new File("src/main/resources/msedgedriver");
                    System.setProperty("webdriver.msedge.driver", file.getAbsolutePath());
                }
                driver = new EdgeDriver();
            }
            default -> Assert.fail("Unsupported browser: " + browserName);
        }
        return driver;
    }

    private static boolean isMac()
    {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("mac")) {
            return true;
        }
        return false;
    }
}
