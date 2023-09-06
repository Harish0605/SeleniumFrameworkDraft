package automationLearning.pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import automationLearning.AbstractComponents.AbstractComponent;


public class Payment extends AbstractComponent {
	WebDriver driver;

	// A constructor is created and WebDriver object is passed as arguments
	public Payment(WebDriver driver) {
		// sending driver to Parent class
		super(driver);
		// initialization
		this.driver = driver;
		// initializing all the elements by taking the driver as argument
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[contains(@class,'ta-item')]/span")
	List<WebElement> countryOptions;
	
	
	@FindBy(xpath="//a[contains(text(),'Place Order')]")
	WebElement placeOrderBtn;
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement countryField;

	By placeOrder = By.xpath("//a[contains(text(),'Place Order')]");
	


	public List<WebElement> getCountryOptionsAndSelect() {
		waitForElementToAppear(placeOrder);
		return countryOptions;

	}

	public void selectCountry(String countryName,String countryActualName) throws InterruptedException {
		countryField.sendKeys(countryName);
		try {
			for (WebElement e : countryOptions) {
				if (e.getText().equals(countryActualName)) {
					e.click();
					System.out.println("Clicked on : " + e.getText());
					break;
				}

			}
		} catch (StaleElementReferenceException ex) {

		}
		scrollIntoElement(placeOrderBtn);
		waitForElementToBeClickable(placeOrder);
		sleep(4000);
		placeOrderBtn.click();
	}	
	
	}
