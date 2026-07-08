import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CartPageTests extends BaseClass {

    @Test
    public void cartPageTests(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"), "Login failed, products page not opened");

        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.addBackpackToCart();
        Assert.assertEquals(productsPage.getCartBadgeCount(),"1","CArt badge should show 1 after adding 1 product to cart");

        productsPage.addBikeLightToCart();
        Assert.assertEquals(productsPage.getCartBadgeCount(),"2","Cart badge should show 2 after adding second product to the cart");


        productsPage.goToCart();

        CartPage cartPage = new CartPage(driver);

        Assert.assertTrue(cartPage.isBackpackDisplayed());
        Assert.assertTrue(cartPage.isBikeLightDisplayed());

        Assert.assertTrue(cartPage.isBackpackRemoveButtonDisplayed());

        cartPage.clickContinueShopping();

        Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://www.saucedemo.com/inventory.html"
        );

        productsPage.goToCart();

        cartPage.clickCheckout();

        Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://www.saucedemo.com/checkout-step-one.html"
        );


    }

}
