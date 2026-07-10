import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class SmokeTest extends BaseClass {

    @Test
    public void sauceDemoSmokeTest(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addBackpackToCart();

        CartPage cartPage = new CartPage(driver);

        Assert.assertTrue(cartPage.isBackpackDisplayed());
        Assert.assertTrue(cartPage.isBikeLightDisplayed());

        cartPage.clickCheckout();

        CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage(driver);

        checkoutInfoPage.fillCheckoutInfo("Sineth", "Shashintha", "12345");
        checkoutInfoPage.clickContinue();

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);

        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-two"),
                "Not redirected to checkout overview page");

        Assert.assertTrue(checkoutOverviewPage.getItemTotalLabel().contains("Item total"),
                "Item total label is not displayed");

        Assert.assertTrue(checkoutOverviewPage.getTaxLabel().contains("Tax"),
                "Tax label is not displayed");

        Assert.assertTrue(checkoutOverviewPage.getTotalLabel().contains("Total"),
                "Total label is not displayed");

        checkoutOverviewPage.clickFinish();

        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-complete"),
                "Finish button did not redirect to order complete page");

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);

        Assert.assertEquals(checkoutCompletePage.getCompletionText(),"Thank you for your order!",
                "Confirmation message is incorrect");

        checkoutCompletePage.clickBacKHomeBtn();

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"),
                "Back Home button did not redirect to inventory / products page");




    }
}
