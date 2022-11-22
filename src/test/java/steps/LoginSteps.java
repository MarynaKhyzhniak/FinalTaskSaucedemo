package steps;

import pages.InventoryPage;
import pages.LoginPage;

import static org.testng.AssertJUnit.assertTrue;

public class LoginSteps {
    public LoginPage loginPage = new LoginPage();
    public InventoryPage inventoryPage = new InventoryPage();

    public LoginSteps doLogin(String user, String pwd) {
        loginPage.fillUserField(user);
        loginPage.fillPasswordField(pwd);
        loginPage.clickLoginButton();
        return new LoginSteps();
    }
    public LoginSteps verifyErrorIfIncorrectLoginData() {
        loginPage.checkErrorIfIncorrectLoginData();
        return this;
    }

    public LoginSteps verifyErrorIfLockedOut() {
        loginPage.checkErrorIfLockedOut();
        return this;
    }

    public LoginSteps verifyFailureWithItemImages() {
       inventoryPage.getListOfItemImages().forEach(element ->
                assertTrue(element.getAttribute("src").contains("static")));
        return this;
    }

    public LoginSteps verifySuccessfulLogin() {
        loginPage.checkFastPageLoadTime();
        loginPage.waitUrlToLoad("https://www.saucedemo.com/inventory.html");
        return this;
    }

    public SortingSteps verifySortingDropdownIsVisible() {
        inventoryPage.checkSortingDropdown();
        return new SortingSteps();
    }

    public LoginSteps verifyLoginWithDelay() {
        loginPage.checkSlowPageLoadTime();
        return this;
    }

    public SocialMediaSteps verifySocialMediaIconsAreVisible() {
        inventoryPage.checkSocialMediaIconsAreVisible();
        return new SocialMediaSteps();
    }

    public CartSteps verifyCartIconIsVisible() {
        inventoryPage.checkCartIconIsVisible();
        return new CartSteps();
    }
}
