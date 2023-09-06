package automationLearning;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationLearning.pageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandaloneTest {

	public static void main(String[] args) throws InterruptedException {
//		String productName = "ADIDAS ORIGINAL";
//		String productName = "ZARA COAT 3";
		String productName = "IPHONE 13 PRO";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("harishchinni84@gmail.com");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Welcome@123");
		driver.findElement(By.xpath("//input[@id='login']")).click();
		wait.until(ExpectedConditions
				.visibilityOfAllElements(driver.findElements(By.xpath("//div[@class='card']"))));
		
		
		List<WebElement> products = driver.findElements(By.xpath("//div[@class='card']//h5/b"));
		for(int i=0;i<products.size();i++){
		String item = products.get(i).getText();
		if(item.equalsIgnoreCase(productName)){
		driver.findElements(By.xpath("//button[contains(text(),'Add')]")).get(i).click();
		break;
		}
		}
//		String beforeXpath = "//b[contains(text(),'";
//		String afterXpath = "')]/parent::h5/following-sibling::button[contains(text(),' Add ')]";
//
//		for (WebElement e : products) {
//			String productSelected = e.getText().toLowerCase();
//			String Xpath = beforeXpath + productSelected + afterXpath;
//			if (productSelected.equalsIgnoreCase(productName)) {
//				driver.findElement(By.xpath(Xpath)).click();
//				break;
//			}
//
//		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		driver.findElement(By.xpath("//button[contains(@routerlink,'/dashboard/cart')]")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='cartSection']//h3")));
		List<WebElement> cartItems = driver.findElements(By.xpath("//div[@class='cartSection']//h3"));
		for (WebElement e : cartItems) {
			Assert.assertEquals(productName, e.getText());
		}
		driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Place Order')]")));
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
		List<WebElement> options = driver.findElements(By.xpath("//button[contains(@class,'ta-item')]/span"));
		try {
			for (WebElement e : options) {
				if (e.getText().equals("India")) {
					e.click();
					System.out.println("Clicked on : " + e.getText());
					break;
				}

			}
		} catch (StaleElementReferenceException ex) {

		}

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(By.xpath("//a[contains(text(),'Place Order')]")));
		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//a[contains(text(),'Place Order')]"))));
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[contains(text(),'Place Order')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
		String confirmMessage = driver.findElement(By.xpath("//h1[@class='hero-primary']")).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		System.out.println(driver.findElement(By.xpath("//label[@class='ng-star-inserted']")).getText());
		driver.quit();

	}

}
