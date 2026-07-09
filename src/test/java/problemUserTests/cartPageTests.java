package problemUserTests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class cartPageTests extends BaseClass {

    @Test
    public void problemUserCartPageIssues(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("problem_user", "secret_sauce");

        ProductsPage productPage = new ProductsPage(driver);
        productPage.addBackpackToCart();

        productPage.goToCart();

        CartPage cartPage = new CartPage(driver);

        Assert.assertTrue(driver.getCurrentUrl().contains("cart"),
                "Did not navigate to cart page");

        Assert.assertTrue(cartPage.isProductDisplayed("Sauce Labs Backpack"),
                "Added product is not displayed in the cart");

    }

}
