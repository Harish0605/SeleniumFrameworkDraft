package automationLearning;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import automationLearning.pageObjects.CheckOut;
import automationLearning.pageObjects.LandingPage;
import automationLearning.pageObjects.OrderConfirmation;
import automationLearning.pageObjects.Payment;
import automationLearning.pageObjects.ProductCatalogue;

public class UpdatedStandaloneTest {

	public static void main(String[] args) throws InterruptedException {

		String item = "IPHONE 13 PRO";// "ADIDAS ORIGINAL";"IPHONE 13 PRO";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
		landingPage.loginApplication("harishchinni84@gmail.com", "Welcome@123");
		ProductCatalogue productCataloguePage = new ProductCatalogue(driver);		
		productCataloguePage.addProduct(item);
		CheckOut checkOutPage = new CheckOut(driver);
		checkOutPage.getCartItems();
		checkOutPage.verifySelectedItemsIncart(item);
		Payment paymentPage = new Payment(driver);
		paymentPage.getCountryOptionsAndSelect();
		paymentPage.selectCountry("ind", "India");
		OrderConfirmation orderConfirmationPage = new OrderConfirmation(driver);
		String OrderId = orderConfirmationPage.getOrderId();
		System.out.println(OrderId);

		driver.quit();

	}

}
