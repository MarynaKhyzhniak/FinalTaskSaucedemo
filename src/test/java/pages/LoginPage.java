package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class LoginPage extends BasePage {

    @FindBy(name = "login-button")
    WebElement loginBtn;

    @FindBy(name = "user-name")
    WebElement userField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement errorMessage;

    public void fillUserField(String username) {
        userField.sendKeys(username);
    }

    public void fillPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginBtn.click();
    }

    public void checkErrorIfLockedOut() {
        assertThat(errorMessage.getText()).isEqualTo("Epic sadface: Sorry, this user has been locked out.");
    }

    public void checkErrorIfIncorrectLoginData() {
        assertThat(errorMessage.getText()).isEqualTo("Epic sadface: Username and password do not match any user in this service");
    }

    public void checkFastPageLoadTime() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long loadEventEnd = (Long) js.executeScript("return window.performance.timing.loadEventEnd;");
        long navigationStart = (Long) js.executeScript("return window.performance.timing.navigationStart;");
        long loadTime = loadEventEnd - navigationStart;
        assertTrue(loadTime < 400);
    }

    public void checkSlowPageLoadTime() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long loadEventEnd = (Long) js.executeScript("return window.performance.timing.loadEventEnd;");
        long navigationStart = (Long) js.executeScript("return window.performance.timing.navigationStart;");
        long loadTime = loadEventEnd - navigationStart;
        assertFalse(loadTime < 20);
    }
}
