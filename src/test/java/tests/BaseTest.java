package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import steps.CartSteps;
import steps.LoginSteps;
import steps.SocialMediaSteps;
import steps.SortingSteps;

import static utils.TestUtils.launchDriver;

public abstract class BaseTest {

    private static final String SAUCEDEMO_URL = "https://www.saucedemo.com/";

    private static WebDriver driver;

    LoginSteps steps;
    SocialMediaSteps socialMediaSteps;
    SortingSteps sortingSteps;
    CartSteps cartSteps;

    @BeforeClass
    public void beforeClass() {
        driver = launchDriver("chrome");
        driver.manage().window().maximize();

        steps = new LoginSteps();
        socialMediaSteps = new SocialMediaSteps();
        sortingSteps = new SortingSteps();
        cartSteps = new CartSteps();
    }

    @BeforeMethod
    public void setUp() {
        getDriver().navigate().to(SAUCEDEMO_URL);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
