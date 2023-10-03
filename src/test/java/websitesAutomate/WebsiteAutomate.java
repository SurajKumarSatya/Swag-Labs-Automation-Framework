package websitesAutomate;

import java.io.IOException;
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
	
		String productName = "Sauce Labs Backpack";

		ProductCatalogue productCatalogue = landingPage.loginApplication("standard_user", "secret_sauce");
		String title = landingPage.verifyTitles();
		Assert.assertTrue(title.equals("Swag Labs"));
			
		//Product Catalogue
		productCatalogue.verifyProductCataloguePageHeading();
		productCatalogue.getProductsList();
		productCatalogue.getProductByName(productName);
		productCatalogue.addToCartButton(productName);
		CartPage cartPage = productCatalogue.clickCartIcon();
		
		/*
		 * filtering the products WebElement prod =
		 * productNames.stream().filter(product->
		 * product.findElement(By.xpath("//div[@class='inventory_item_name']")).getText(
		 * ).equals(productName)).findFirst().orElse(null); stream() --> stream() will
		 * help to iterate through each and every item present in the productNames.
		 * filter --> to apply the condition on the basis of which we have to filter.
		 * product --> whatever the stream() gave as the output in the first iteration,
		 * it will be stored in the product (you can change the name according to you)
		 * 
		 * prod.findElement(By.
		 * xpath("//button[@class='btn btn_primary btn_small btn_inventory']")).click();
		 */
			
		//CartIcon
		String cartProductNames = cartPage.checkProductNames(productName);
		Assert.assertTrue(cartProductNames.equalsIgnoreCase("Sauce Labs Backpack"));
		CheckoutPage checkoutPage = cartPage.clickCheckoutBtn();
		
		checkoutPage.enterInfo();
		OverviewPage overviewPage = checkoutPage.clickContinueBtn();
		
		//OverviewPage
		overviewPage.getPrice();
		ConfirmationPage confirmationPage = overviewPage.clickFinishBtn();
		
		//ConfirmationPage
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thank you for your order!"));
	}
	
	
}
