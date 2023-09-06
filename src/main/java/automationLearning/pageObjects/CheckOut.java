package automationLearning.pageObjects;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationLearning.AbstractComponents.AbstractComponent;

public class CheckOut extends AbstractComponent {
	WebDriver driver;

	// A constructor is created and WebDriver object is passed as arguments
	public CheckOut(WebDriver driver) {
		// sending driver to Parent class
		super(driver);
		// initialization
		this.driver = driver;
		// initializing all the elements by taking the driver as argument
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='cartSection']//h3")
	List<WebElement> cartItems;

	@FindBy(xpath = "//button[contains(text(),'Checkout')]")
	WebElement checkoutButton;

	By cartSection = By.xpath("//div[@class='cartSection']//h3");

	public List<WebElement> getCartItems() {
		waitForElementsToAppear(cartSection);
		return cartItems;

	}

	public void verifySelectedItemsIncart(String productName) {
//		for (WebElement e : cartItems) {
////			No Assert should be there in Page object classes and it should be present in your test
////			Assert.assertEquals(productName, e.getText());
//			if(productName.equalsIgnoreCase(e.getText())) {
//				System.out.println(e.getText());
//			}
//		}
		checkoutButton.click();

	}

}
