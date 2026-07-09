package problemUserTests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class productPageTests extends BaseClass {

    @Test
    public void problemUserProductIssues(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("problem_user", "secret_sauce");

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"),
                "problem_user did not land on inventory page");

        ProductsPage productPage = new ProductsPage(driver);

        Assert.assertTrue(productPage.isProductTitleDisplayed(),
                "Product title is not displayed correctly");

        Assert.assertTrue(productPage.isInventoryPageLoaded(),
                "Products page did not load correctly for problem_user");

    }

}
