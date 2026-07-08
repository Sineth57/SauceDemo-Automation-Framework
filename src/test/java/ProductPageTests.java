import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductPageTests extends BaseClass {

    @Test
    public void productPageTests(){

        standardUserLogin();

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"), "Login failed, products page not opened");

        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.addBackpackToCart();
        Assert.assertEquals(productsPage.getCartBadgeCount(),"1","CArt badge should show 1 after adding 1 product to cart");

        productsPage.addBikeLightToCart();
        Assert.assertEquals(productsPage.getCartBadgeCount(),"2","Cart badge should show 2 after adding second product to the cart");

        productsPage.addTshirttoCart();
        Assert.assertEquals(productsPage.getCartBadgeCount(),"3", "Cart badge should show 3 adter adding third product to the cart");


        Assert.assertTrue(productsPage.isRemoveButtonDisplayedForBackpack(),
                "Backpack remove button visible");
        Assert.assertTrue(productsPage.isRemoveButtonDisplayedForBikeLight(),
                "Bike light remove button visible");

    }


}
