package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
    WebElement backpackName;

    @FindBy(xpath = "//div[text()='Sauce Labs Bike Light']")
    WebElement bikeLightName;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeBackpackBtn;

    @FindBy(id = "remove-sauce-labs-bike-light")
    WebElement removeBikeLightBtn;

    @FindBy(id = "continue-shopping")
    WebElement continueShoppingBtn;

    @FindBy(id = "checkout")
    WebElement checkoutBtn;

    public boolean isBackpackDisplayed() {
        return backpackName.isDisplayed();
    }

    public boolean isBikeLightDisplayed() {
        return bikeLightName.isDisplayed();
    }

    public boolean isBackpackRemoveButtonDisplayed() {
        return removeBackpackBtn.isDisplayed();
    }

    public void removeBackpact(){
        removeBackpackBtn.click();
    }

    public void clickContinueShopping() {
        continueShoppingBtn.click();
    }

    public void clickCheckout() {
        checkoutBtn.click();
    }

   public boolean isProductDisplayed(String productName) {
        return driver.getPageSource().contains(productName);
    }
}
