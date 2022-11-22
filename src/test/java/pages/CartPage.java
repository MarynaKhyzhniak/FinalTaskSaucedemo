package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(xpath = "//button[contains(@id,'remove')]")
    private List<WebElement> removeButton;

    @FindBy(xpath = "//button[@name='checkout']")
    private WebElement checkoutButton;

    public void clickRemoveButton() {
        removeButton.get(0).click();
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }

}
