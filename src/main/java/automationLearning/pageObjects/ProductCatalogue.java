package automationLearning.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationLearning.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	WebDriver driver;

	// A constructor is created and WebDriver object is passed as arguments
	public ProductCatalogue(WebDriver driver) {
		// sending driver to Parent class
		super(driver);
		// initialization
		this.driver = driver;
		// initializing all the elements by taking the driver as argument
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='card-body']/h5/b")
	List<WebElement> products;

	@FindBy(xpath = "//button[contains(text(),'Add To Cart')]")
	List<WebElement> addToCartList;

	@FindBy(xpath = "//button[contains(@routerlink,'/dashboard/cart')]")
	WebElement cartButton;
    
	By productsBy = By.xpath("//div[@class='card-body']/h5/b");
	By addedpopup = By.xpath("//div[@id='toast-container']");
	By spinner = By.cssSelector("ng-animating");

	public void addProduct(String productName) {
		waitForElementsToAppear(productsBy);
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getText().equalsIgnoreCase(productName)) {
				addToCartList.get(i).click();
				break;
			}
			
		}
		waitForElementToAppear(addedpopup);
		waitForElementToDisAppear(spinner);
		cartButton.click();

	}

}
