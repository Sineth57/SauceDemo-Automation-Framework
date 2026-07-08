package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutInfoPage {

    WebDriver driver;

    public CheckoutInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "first-name")
    WebElement firstNameInput;

    @FindBy(id = "last-name")
    WebElement lastNameInput;

    @FindBy(id = "postal-code")
    WebElement postalCodeInput;

    @FindBy(id = "continue")
    WebElement continueButton;

    @FindBy(id = "cancel")
    WebElement cancelButton;


    public void enterFirstName(String firstName){
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode) {
        postalCodeInput.clear();
        postalCodeInput.sendKeys(postalCode);
    }

    public void fillCheckoutInfo(String firstName, String lastName, String postalCode) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostalCode(postalCode);
    }

    public void clickContinue() {
        continueButton.click();
    }

    public void clickCancel() {
        cancelButton.click();
    }

}
