package steps;

import org.testng.Assert;
import pages.InventoryPage;
import tests.BaseTest;

import java.time.Duration;

public class SocialMediaSteps extends BaseTest {

    public InventoryPage inventoryPage = new InventoryPage();

    private String TWITTER_URL = "https://twitter.com/saucelabs";
    private String FACEBOOK_URL = "https://www.facebook.com/saucelabs";
    private String LINKEDIN_URL = "https://www.linkedin.com/company/sauce-labs/?original_referer=";

    public SocialMediaSteps verifyUserIsRedirectedToTwitterPage() {
        inventoryPage.clickTwitterIcon();
        inventoryPage.switchToNewTab();
        inventoryPage.waitForPageLoadComplete(Duration.ofSeconds(5));
        Assert.assertEquals(inventoryPage.getCurrentUrl(), TWITTER_URL);
        inventoryPage.closeTab();
        inventoryPage.switchToPreviousTab();
        return new SocialMediaSteps();
    }

    public SocialMediaSteps verifyUserIsRedirectedToFacebookPage() {
        inventoryPage.clickFacebookIcon();
        inventoryPage.switchToNewTab();
        inventoryPage.waitForPageLoadComplete(Duration.ofSeconds(5));
        Assert.assertEquals(inventoryPage.getCurrentUrl(), FACEBOOK_URL);
        inventoryPage.closeTab();
        inventoryPage.switchToPreviousTab();
        return new SocialMediaSteps();
    }

    public SocialMediaSteps verifyUserIsRedirectedToLinkedInPage() {
        inventoryPage.clickLinkedInIcon();
        inventoryPage.switchToNewTab();
        inventoryPage.waitForPageLoadComplete(Duration.ofSeconds(5));
        Assert.assertEquals(inventoryPage.getCurrentUrl(), LINKEDIN_URL);
        inventoryPage.closeTab();
        inventoryPage.switchToPreviousTab();
        return new SocialMediaSteps();
    }
}
