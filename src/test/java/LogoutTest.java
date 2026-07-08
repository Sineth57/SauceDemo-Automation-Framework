import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class LogoutTest extends BaseClass {

    @Test
    public void logoutTest(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.logout();

        String expectedUrl = "https://www.saucedemo.com/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

    }


}
