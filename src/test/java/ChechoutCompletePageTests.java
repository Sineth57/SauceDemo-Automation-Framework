import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class ChechoutCompletePageTests extends BaseClass {

    @Test
    public void checkoutCompletePageTests() throws InterruptedException {

        standardUserLogin();
        addTwoProductsToCart();

        productPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();


        CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage(driver);
        checkoutInfoPage.fillCheckoutInfo("Test", "User", "12345");
        checkoutInfoPage.clickContinue();

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.clickFinish();

        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-complete"),
                "Finish button did not redirect to order complete page");

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);

        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-complete"),
                "Not redirected to checkout complete page");

        Assert.assertEquals(checkoutCompletePage.getCompletionText(),"Thank you for your order!",
                "Confirmation message is incorrect");

        checkoutCompletePage.clickBacKHomeBtn();

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"),
                "Back Home button did not redirect to inventory / products page");

    }

}
