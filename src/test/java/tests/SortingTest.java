package tests;

import org.testng.annotations.Test;
import steps.LoginSteps;

public class SortingTest extends BaseTest {

    @Test
    public void testSortingItemsFromCheapToExpensive() {
        LoginSteps loginSteps = steps.doLogin("standard_user", "secret_sauce");
        loginSteps.verifySortingDropdownIsVisible();
        sortingSteps.sortItems("lohi").verifySortingByPriceASC();
    }

    @Test
    public void testSortingItemsFromExpensiveToCheap() {
        LoginSteps loginSteps = steps.doLogin("standard_user", "secret_sauce");
        loginSteps.verifySortingDropdownIsVisible();
        sortingSteps.sortItems("hilo").verifySortingByPriceDESC();
    }

    @Test
    public void testSortingItemsFromAToZ() {
        LoginSteps loginSteps = steps.doLogin("standard_user", "secret_sauce");
        loginSteps.verifySortingDropdownIsVisible();
        sortingSteps.sortItems("az").verifySortingByNameAZ();
    }

    @Test
    public void testSortingItemsFromZToA() {
        LoginSteps loginSteps = steps.doLogin("standard_user", "secret_sauce");
        loginSteps.verifySortingDropdownIsVisible();
        sortingSteps.sortItems("za").verifySortingByNameZA();
    }
}
