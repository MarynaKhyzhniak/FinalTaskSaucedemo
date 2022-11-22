package tests;

import org.testng.annotations.Test;
import steps.LoginSteps;

public class LoginTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        LoginSteps loginSteps = steps.doLogin("standard_user", "secret_sauce");
        loginSteps.verifySuccessfulLogin();
    }

    @Test
    public void testFailedLoginWithLockedOutUser() {
        LoginSteps loginSteps = steps.doLogin("locked_out_user", "secret_sauce");
        loginSteps.verifyErrorIfLockedOut();
    }

    @Test
    public void testUnsuccessfulLoginWithProblemUser() {
        LoginSteps loginSteps = steps.doLogin("problem_user", "secret_sauce");
        loginSteps.verifyFailureWithItemImages();
    }

    @Test
    public void testUnsuccessfulLoginWithPerformanceGlitchUser() {
        LoginSteps loginSteps = steps.doLogin("performance_glitch_user", "secret_sauce");
        loginSteps.verifyLoginWithDelay();
    }

    @Test
    public void testFailedLoginWithIncorrectData() {
        LoginSteps loginSteps = steps.doLogin("test", "test");
        loginSteps.verifyErrorIfIncorrectLoginData();
    }
}
