import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutOverviewTests extends BaseClass {

    @Test
    public void checkoutOverviewPageTests() throws InterruptedException {

        standardUserLogin();
        addTwoProductsToCart();

        productPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage(driver);
        checkoutInfoPage.fillCheckoutInfo("Sineth", "shashintha", "12345");
        checkoutInfoPage.clickContinue();


        Thread.sleep(2000);

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);

        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-two"),
                "Not redirected to checkout overview page");

        Assert.assertTrue(checkoutOverviewPage.getItemTotalLabel().contains("Item total"),
                "Item total label is not displayed");

        Assert.assertTrue(checkoutOverviewPage.getTaxLabel().contains("Tax"),
                "Tax label is not displayed");

        Assert.assertTrue(checkoutOverviewPage.getTotalLabel().contains("Total"),
                "Total label is not displayed");

        checkoutOverviewPage.clickCancel();

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"),
                "Cancel button did not redirect back to products page");

        productPage = new ProductsPage(driver);
        productPage.goToCart();

        cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        checkoutInfoPage = new CheckoutInfoPage(driver);
        checkoutInfoPage.fillCheckoutInfo("Test", "User", "12345");
        checkoutInfoPage.clickContinue();

        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.clickFinish();

        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-complete"),
                "Finish button did not redirect to order complete page");


    }

}
