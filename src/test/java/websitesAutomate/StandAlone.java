package websitesAutomate;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import pageObjects.LandingPage;


public class StandAlone 
{
	public static void main(String args[])
	{
		WebDriver driver; 
		String productName = "Sauce Labs Backpack";
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options); 
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
		LandingPage landingPage = new LandingPage(driver);
		
		//verify title
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = "Swag Labs";
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("1");
		
		//login credentials entered
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		System.out.println("2");
		
		//verify 'Products' heading
		String heading = driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText();
		Assert.assertEquals(heading,"Products");
		System.out.println("3");
		
		//getting products names
		List<WebElement> productNames = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		
		//inventory_item
	//	List<WebElement> productNames = driver.findElements(By.className("inventory_item"));

		System.out.println("4");
		
		//filtering the products
		
//		for (WebElement webElement : productNames) {
//			String name = webElement.getText();
//			System.out.println(name);
//			if(name.equalsIgnoreCase(productName))
//			{
//				driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']")).click();
//			}
			
			WebElement prod = productNames.stream().filter(product->
			product.findElement(By.xpath("//div[@class='inventory_item_name']")).getText().equals(productName)).findFirst().orElse(null);
		//  stream() --> stream() will help to iterate through each and every item present in the productNames.
		//  filter --> to apply the condition on the basis of which we have to filter.
		//  product --> whatever the stream() gave as the output in the first iteration, it will be stored in the product (you can change the name according to you)
			
			prod.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']")).click();
			
//		}
		System.out.println("6");
		
		//clicking the cart icon
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		
		//check the product name in cart page
		String cartProductName = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
		Assert.assertEquals(productName, cartProductName);
		
		//click the 'checkout' button
		driver.findElement(By.id("checkout")).click();
		
		//entering details
		driver.findElement(By.id("first-name")).sendKeys("Ravi");
		driver.findElement(By.id("last-name")).sendKeys("Kumar");
		driver.findElement(By.id("postal-code")).sendKeys("000000");
		
		//clicking 'Continue' button
		driver.findElement(By.id("continue")).click();
		
		//get Total Price
		String price = driver.findElement(By.xpath("//div[@class='summary_info_label summary_total_label']")).getText();
		System.out.println(price);
		
		//click the 'Finish' button
		driver.findElement(By.id("finish")).click();
		
		//verify message
		String expectedMessage = "Thank you for your order!";
		String actualMessage = driver.findElement(By.xpath("//h2[@class='complete-header']")).getText();
		Assert.assertEquals(expectedMessage, actualMessage);
	}
}
