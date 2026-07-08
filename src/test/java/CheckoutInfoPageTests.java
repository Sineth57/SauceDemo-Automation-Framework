import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutInfoPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CheckoutInfoPageTests extends BaseClass {

    @Test
    public void checkInformationTests(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productPage = new ProductsPage(driver);
        productPage.addBackpackToCart();
        productPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage(driver);

        checkoutInfoPage.fillCheckoutInfo("Sineth", "Shashintha", "12345");
        checkoutInfoPage.clickContinue();


        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-two"),
                "Continue button did not redirect to checkout overview page");

        driver.navigate().back();

        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-one"),
                "Did not return to checkout information page after back navigation");

        checkoutInfoPage.clickCancel();

        Assert.assertTrue(driver.getCurrentUrl().contains("cart"),
                "Cancel button did not redirect to cart page");

    }

    
}
