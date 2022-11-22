package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckoutCompletePage extends BasePage {

    @FindBy(name = "back-to-products")
    WebElement backHomeButton;

    @FindBy(xpath = "//h2[@class = 'complete-header']")
    WebElement thankYouMessage;

    @FindBy(xpath = "//div[@class = 'complete-text']")
    WebElement completeText;

    public void clickBackHomeButton() {
        backHomeButton.click();
    }

    public void checkThankYouMessage() {
        assertThat(thankYouMessage.getText()).isEqualTo("THANK YOU FOR YOUR ORDER");
    }

    public void checkCompleteText() {
        assertThat(completeText.getText()).isEqualTo("Your order has been dispatched, and will arrive just as fast as the pony can get there!");
    }
}
