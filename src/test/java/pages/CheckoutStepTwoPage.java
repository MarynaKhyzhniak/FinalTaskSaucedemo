package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutStepTwoPage extends BasePage {

    @FindBy(name = "finish")
    WebElement finishButton;

    public void clickFinishButton() {
        finishButton.click();
    }
}
