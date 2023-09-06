package automationLearning.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationLearning.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver;
	
	// A constructor is created and WebDriver object is passed as arguments
	public LandingPage(WebDriver driver) {
		//initialization
		super(driver);
		this.driver=driver;
		//initializing all the elements by taking the driver as argument
		PageFactory.initElements(driver, this);
	}
	
//WebElement username = driver.findElement(By.xpath("//input[@id='userEmail']"));
	//PageFactory design Pattern - we can reduce the syntax of creating WebElement by using @FindBy
	@FindBy(xpath="//input[@id='userEmail']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='userPassword']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='login']")
	WebElement login;
	
	
	public void loginApplication(String email,String passKey) {
		username.sendKeys(email);
		password.sendKeys(passKey);
		login.click();
		
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}

	

}
