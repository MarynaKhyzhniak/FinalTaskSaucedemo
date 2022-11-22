package tests;

import org.testng.annotations.Test;
import steps.LoginSteps;

public class SocialMediaTest extends BaseTest {

    @Test
    public void testTwitterRedirection() {
        LoginSteps loginSteps = steps.doLogin("standard_user", "secret_sauce");
        loginSteps.verifySocialMediaIconsAreVisible();
        socialMediaSteps.verifyUserIsRedirectedToTwitterPage();
    }

    @Test
    public void testFacebookRedirection() {
        LoginSteps loginSteps = steps.doLogin("standard_user", "secret_sauce");
        loginSteps.verifySocialMediaIconsAreVisible();
        socialMediaSteps.verifyUserIsRedirectedToFacebookPage();
    }

    @Test
    public void testLinkedInRedirection() {
        LoginSteps loginSteps = steps.doLogin("standard_user", "secret_sauce");
        loginSteps.verifySocialMediaIconsAreVisible();
        socialMediaSteps.verifyUserIsRedirectedToLinkedInPage();
    }
}
