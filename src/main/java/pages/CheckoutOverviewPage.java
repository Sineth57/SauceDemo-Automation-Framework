package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage {

    WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "summary_subtotal_label")
    WebElement itemTotalLabel;

    @FindBy(className = "summary_tax_label")
    WebElement taxLabel;

    @FindBy(className = "summary_total_label")
    WebElement totalLabel;

    @FindBy(id = "finish")
    WebElement finishButton;

    @FindBy(id = "cancel")
    WebElement cancelButton;

    public String getItemTotalLabel() {
        return itemTotalLabel.getText();
    }

    public String getTaxLabel() {
        return taxLabel.getText();
    }

    public String getTotalLabel() {
        return totalLabel.getText();
    }

    public void clickFinish() {
        finishButton.click();
    }

    public void clickCancel() {
        cancelButton.click();
    }

}
