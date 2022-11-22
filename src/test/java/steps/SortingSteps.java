package steps;

import pages.InventoryPage;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class SortingSteps {

    public InventoryPage inventoryPage = new InventoryPage();

    public SortingSteps sortItems(String value) {
        inventoryPage.selectSortingInDropdown(value);
        return new SortingSteps();
    }

    public SortingSteps verifySortingByPriceASC() {
        inventoryPage.waitForPageLoadComplete(Duration.ofSeconds(5));
        assertEquals(inventoryPage.getSortedListOfItemsByPriceASC(), inventoryPage.getListOfItemsByPrice());
        return new SortingSteps();
    }

    public SortingSteps verifySortingByPriceDESC() {
        inventoryPage.waitForPageLoadComplete(Duration.ofSeconds(5));
        assertEquals(inventoryPage.getSortedListOfItemsByPriceDESC(), inventoryPage.getListOfItemsByPrice());
        return new SortingSteps();
    }

    public SortingSteps verifySortingByNameAZ() {
        inventoryPage.waitForPageLoadComplete(Duration.ofSeconds(5));
        assertEquals(inventoryPage.getSortedListOfItemsByNameAZ(), inventoryPage.getListOfItemsByName());
        return new SortingSteps();
    }

    public SortingSteps verifySortingByNameZA() {
        inventoryPage.waitForPageLoadComplete(Duration.ofSeconds(5));
        assertEquals(inventoryPage.getSortedListOfItemsByNameZA(), inventoryPage.getListOfItemsByName());
        return new SortingSteps();
    }
}
