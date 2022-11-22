package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class InventoryPage extends BasePage {

    @FindBy(xpath = "//div[@class='inventory_item']")
    private List<WebElement> items;

    @FindBy(xpath = "//img[@class='inventory_item_img']")
    private List<WebElement> itemsImage;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private List<WebElement> itemPrice;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private List<WebElement> itemName;

    @FindBy(xpath = "//button[contains(@id,'add-to-cart')]")
    private List<WebElement> addToCartButton;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement sortingDropdown;

    @FindBy(xpath = "//li[@class='social_twitter']/a")
    private WebElement twitterIcon;

    @FindBy(xpath = "//li[@class='social_facebook']/a")
    private WebElement facebookIcon;

    @FindBy(xpath = "//li[@class='social_linkedin']/a")
    private WebElement linkedInIcon;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement cartIcon;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    WebElement itemsQuantityInCartIcon;

    public List<WebElement> getListOfItemImages() {
        return itemsImage;
    }

    public void checkSortingDropdown() {
        waitVisibilityOfElement(Duration.ofSeconds(5), sortingDropdown);
    }

    public void selectSortingInDropdown(String value) {
        Select dropdownElement = new Select(sortingDropdown);
        dropdownElement.selectByValue(value);
    }

    public ArrayList getListOfItemsByPrice() {
        ArrayList<Double> obtainedList = new ArrayList<>();
        List<WebElement> elementList = itemPrice;
        for (WebElement webElement : elementList) {
            obtainedList.add(Double.valueOf(webElement.getText().substring(1)));
        }
        return obtainedList;
    }

    public ArrayList getSortedListOfItemsByPriceASC() {
        ArrayList<Double> obtainedList = new ArrayList<>();
        List<WebElement> elementList = itemPrice;
        for (WebElement webElement : elementList) {
            obtainedList.add(Double.valueOf(webElement.getText().substring(1)));
        }
        ArrayList<Double> sortedList = new ArrayList<>(obtainedList);
        Collections.sort(sortedList);
        return sortedList;
    }

    public ArrayList getSortedListOfItemsByPriceDESC() {
        ArrayList<Double> obtainedList = new ArrayList<>();
        List<WebElement> elementList = itemPrice;
        for (WebElement webElement : elementList) {
            obtainedList.add(Double.valueOf(webElement.getText().substring(1)));
        }
        ArrayList<Double> sortedList = new ArrayList<>(obtainedList);
        sortedList.sort(Collections.reverseOrder());
        return sortedList;
    }

    public ArrayList getListOfItemsByName() {
        ArrayList<String> obtainedList = new ArrayList<>();
        List<WebElement> elementList = itemName;
        for (WebElement webElement : elementList) {
            obtainedList.add(webElement.getText());
        }
        return obtainedList;
    }

    public ArrayList getSortedListOfItemsByNameAZ() {
        ArrayList<String> obtainedList = new ArrayList<>();
        List<WebElement> elementList = itemName;
        for (WebElement webElement : elementList) {
            obtainedList.add(webElement.getText());
        }
        ArrayList<String> sortedList = new ArrayList<>(obtainedList);
        Collections.sort(sortedList);
        return sortedList;
    }

    public ArrayList getSortedListOfItemsByNameZA() {
        ArrayList<String> obtainedList = new ArrayList<>();
        List<WebElement> elementList = itemName;
        for (WebElement webElement : elementList) {
            obtainedList.add(webElement.getText());
        }
        ArrayList<String> sortedList = new ArrayList<>(obtainedList);
        sortedList.sort(Collections.reverseOrder());
        return sortedList;
    }

    public void checkSocialMediaIconsAreVisible() {
        waitVisibilityOfElement(Duration.ofSeconds(5), twitterIcon);
        waitVisibilityOfElement(Duration.ofSeconds(5), facebookIcon);
        waitVisibilityOfElement(Duration.ofSeconds(5), linkedInIcon);
    }

    public void clickTwitterIcon() {
        twitterIcon.click();
    }

    public void clickFacebookIcon() {
        facebookIcon.click();
    }

    public void clickLinkedInIcon() {
        linkedInIcon.click();
    }

    public void clickAddToCartButton() {
        addToCartButton.get(0).click();
    }

    public void checkCartIconIsVisible() {
        waitVisibilityOfElement(Duration.ofSeconds(5), cartIcon);
    }

    public String getItemsQuantityInCart() {
        return itemsQuantityInCartIcon.getText();
    }

    public void clickCartIcon() {
        cartIcon.click();
    }
}
