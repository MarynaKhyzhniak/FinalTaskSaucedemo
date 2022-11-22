package tests;

import org.testng.annotations.Test;
import steps.LoginSteps;

public class CartTest extends BaseTest {

    @Test
    public void testAddingItemToCart() {
        LoginSteps loginSteps = steps.doLogin("standard_user", "secret_sauce");
        loginSteps.verifyCartIconIsVisible();
        cartSteps.verifyItemIsAddedToCart();
    }

    @Test
    public void testRemovingItemFromCart() {
        LoginSteps loginSteps = steps.doLogin("standard_user", "secret_sauce");
        loginSteps.verifyCartIconIsVisible();
        cartSteps.verifyItemIsAddedToCart();
        cartSteps.verifyItemIsRemovedFromCart();
    }

    @Test
    public void testOrderCompletion() {
        LoginSteps loginSteps = steps.doLogin("standard_user", "secret_sauce");
        loginSteps.verifyCartIconIsVisible();
        cartSteps.verifyItemIsAddedToCart();
        cartSteps.checkoutCart();
    }
}
