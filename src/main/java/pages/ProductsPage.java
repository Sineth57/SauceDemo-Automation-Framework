package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    WebElement backPackAddButton;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement bikeLightAddButton;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
    WebElement tshirtAddButton;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']")
    WebElement jacketAddButton;

    @FindBy(className = "shopping_cart_badge")
    WebElement cartBadge;

    @FindBy(className = "shopping_cart_link")
    WebElement cartIcon;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement backpackRemoveButton;

    @FindBy(id = "remove-sauce-labs-bike-light")
    WebElement bikeLightRemoveButton;

    @FindBy(id = "logout_sidebar_link")
    WebElement logoutButton;

    @FindBy(id = "react-burger-menu-btn")
    WebElement menuButton;


    public void addBackpackToCart() {
        backPackAddButton.click();
    }

    public void addBikeLightToCart() {
        bikeLightAddButton.click();
    }

    public void addTshirttoCart() {
        tshirtAddButton.click();
    }

    public String getCartBadgeCount() {
        return cartBadge.getText();
    }

    public void goToCart() {
        cartIcon.click();
    }

    public boolean isRemoveButtonDisplayedForBackpack() {
        return backpackRemoveButton.isDisplayed();
    }

    public boolean isRemoveButtonDisplayedForBikeLight() {
        return bikeLightRemoveButton.isDisplayed();
    }

    public void logout(){
        menuButton.click();
        logoutButton.click();
    }

}
