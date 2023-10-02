package websitesAutomate;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.ConfirmationPage;
import pageObjects.OverviewPage;
import pageObjects.ProductCatalogue;
import testComponents.BaseTest;


public class WebsiteAutomate extends BaseTest
{
	@Test
	public void websiteAutomateTest() throws IOException, InterruptedException
	{
	//	WebDriver driver; 
		String productName = "Sauce Labs Backpack";
	//	String expectedTitle = "Swag Labs";
	//	String expectedMessage = "Thank you for your order!";

		//Login
//		LandingPage landingPage = new LandingPage(driver);
//		LandingPage landingPage = launchApplication();
//		landingPage.goTo();
		ProductCatalogue productCatalogue = landingPage.loginApplication("standard_user", "secret_sauce");
		String title = landingPage.verifyTitles();
		Assert.assertTrue(title.equals("Swag Labs"));
		
		/*
		 * //verify title String actualTitle = driver.getTitle();
		 * System.out.println(actualTitle); String expectedTitle = "Swag Labs";
		 * Assert.assertEquals(actualTitle, expectedTitle); System.out.println("1");
		 */
		
		/*
		 * //login credentials entered
		 * driver.findElement(By.id("user-name")).sendKeys("standard_user");
		 * driver.findElement(By.id("password")).sendKeys("secret_sauce");
		 * driver.findElement(By.id("login-button")).click(); System.out.println("2");
		 */
		
		//Product Catalogue
//		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		productCatalogue.verifyProductCataloguePageHeading();
		productCatalogue.getProductsList();
		productCatalogue.getProductByName(productName);
		productCatalogue.addToCartButton(productName);
		CartPage cartPage = productCatalogue.clickCartIcon();
		
		
		//verify 'Products' heading
		/*
		 * ProductCatalogue productCatalogue = new ProductCatalogue(driver); String
		 * heading =
		 * driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText()
		 * ; Assert.assertEquals(heading,"Products"); System.out.println("3");
		 */
		
		//getting products names
		/*
		 * List<WebElement> productNames =
		 * driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		 */		
		//inventory_item
	//	List<WebElement> productNames = driver.findElements(By.className("inventory_item"));

		//System.out.println("4");
		
		//filtering the products					
	//	WebElement prod = productNames.stream().filter(product->
	//	product.findElement(By.xpath("//div[@class='inventory_item_name']")).getText().equals(productName)).findFirst().orElse(null);
		//  stream() --> stream() will help to iterate through each and every item present in the productNames.
		//  filter --> to apply the condition on the basis of which we have to filter.
		//  product --> whatever the stream() gave as the output in the first iteration, it will be stored in the product (you can change the name according to you)
			
	//	prod.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']")).click();
			
//		}
		System.out.println("6");
		
		//CartIcon
//		CartPage cartPage = new CartPage(driver);
//		cartPage.clickCartIcon();
		String cartProductNames = cartPage.checkProductNames(productName);
		Assert.assertTrue(cartProductNames.equalsIgnoreCase("Sauce Labs Backpack"));
		CheckoutPage checkoutPage = cartPage.clickCheckoutBtn();
		
		//clicking the cart icon
//		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		
		//check the product name in cart page
//		String cartProductName = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
//		Assert.assertEquals(productName, cartProductName);
		
		//CheckoutPage
//		CheckoutPage checkoutPage = new CheckoutPage(driver);
//		checkoutPage.clickCheckoutBtn();
		checkoutPage.enterInfo();
		OverviewPage overviewPage = checkoutPage.clickContinueBtn();
		
		//click the 'checkout' button
//		driver.findElement(By.id("checkout")).click();
		
		//entering details
//		driver.findElement(By.id("first-name")).sendKeys("Ravi");
//		driver.findElement(By.id("last-name")).sendKeys("Kumar");
//		driver.findElement(By.id("postal-code")).sendKeys("000000");
		
		//OverviewPage
//		OverviewPage overviewPage = new OverviewPage(driver);
//		overviewPage.clickContinueBtn();
		overviewPage.getPrice();
		ConfirmationPage confirmationPage = overviewPage.clickFinishBtn();
		
		
		//clicking 'Continue' button
//		driver.findElement(By.id("continue")).click();
		
		//get Total Price
//		String price = driver.findElement(By.xpath("//div[@class='summary_info_label summary_total_label']")).getText();
//		System.out.println(price);
		
		//click the 'Finish' button
//		driver.findElement(By.id("finish")).click();
		
		//ConfirmationPage
//		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thank you for your order!"));
		//verify message
//		String expectedMessage = "Thank you for your order!";
//		String actualMessage = driver.findElement(By.xpath("//h2[@class='complete-header']")).getText();
//		Assert.assertEquals(expectedMessage, actualMessage);
	}
	
	
}
