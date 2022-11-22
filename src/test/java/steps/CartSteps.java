package steps;

import org.testng.Assert;
import pages.*;

public class CartSteps{

    public InventoryPage inventoryPage = new InventoryPage();
    public CartPage cartPage = new CartPage();
    public CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage();
    public CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage();
    public CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();


    public CartSteps verifyItemIsAddedToCart() {
        inventoryPage.clickAddToCartButton();
        Assert.assertNotEquals(inventoryPage.getItemsQuantityInCart(), "0");
        return new CartSteps();
    }

    public CartSteps verifyItemIsRemovedFromCart() {
        inventoryPage.clickCartIcon();
        cartPage.clickRemoveButton();
        return new CartSteps();
    }

    public CartSteps checkoutCart() {
        inventoryPage.clickCartIcon();
        cartPage.clickCheckoutButton();
        checkoutStepOnePage.fillFirstNameField("UserName");
        checkoutStepOnePage.fillLastNameField("UserSurname");
        checkoutStepOnePage.fillPostalCodeField("76110");
        checkoutStepOnePage.clickContinueButton();
        checkoutStepTwoPage.clickFinishButton();
        checkoutCompletePage.checkThankYouMessage();
        checkoutCompletePage.checkCompleteText();
        checkoutCompletePage.clickBackHomeButton();
        return new CartSteps();
    }
}
