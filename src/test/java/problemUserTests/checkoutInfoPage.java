package problemUserTests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutInfoPage;
import pages.LoginPage;
import pages.ProductsPage;

public class checkoutInfoPage extends BaseClass {

    @Test
    public void problemUserCheckoutInfoIssues(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("problem_user", "secret_sauce");

        ProductsPage productPage = new ProductsPage(driver);
        productPage.addBackpackToCart();
        productPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage(driver);

        checkoutInfoPage.enterFirstName("sineth");
        checkoutInfoPage.enterLastName("shashintha");
        checkoutInfoPage.enterPostalCode("123456");
        checkoutInfoPage.clickContinue();

        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-two"),
                "problem_user did not continue to checkout overview page");


    }

}
