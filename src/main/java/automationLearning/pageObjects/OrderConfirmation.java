package automationLearning.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import automationLearning.AbstractComponents.AbstractComponent;

public class OrderConfirmation extends AbstractComponent {
	WebDriver driver;

	// A constructor is created and WebDriver object is passed as arguments
	public OrderConfirmation(WebDriver driver) {
		// sending driver to Parent class
		super(driver);
		// initialization
		this.driver = driver;
		// initializing all the elements by taking the driver as argument
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//label[@class='ng-star-inserted']")
	WebElement orderId;

	@FindBy(xpath = "//h1[@class='hero-primary']")
	WebElement successHeader;

	By confirmationHeader = By.xpath("//h1");

	public String getOrderId() {
		waitForElementToAppear(confirmationHeader);
		return orderId.getText();

	}

}
