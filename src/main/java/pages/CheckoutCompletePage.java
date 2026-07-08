package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage {

    WebDriver driver;

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='checkout_complete_container']/h2")
    WebElement checkoutCompleteLabel;

    @FindBy(id="back-to-products")
    WebElement backToHomeButton;


    public String getCompletionText(){
        return checkoutCompleteLabel.getText();
    }

    public void clickBacKHomeBtn(){
        backToHomeButton.click();
    }



}
