package websitesAutomate;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.ProductCatalogue;
import testComponents.BaseTest;
import testComponents.Retry;


public class ErrorValidationTest extends BaseTest
{
	@Test(groups= {"ErrorHandling"}, retryAnalyzer=Retry.class)
	public void loginErrorVal() throws IOException, InterruptedException
	{
		landingPage.loginApplication("standard_user", "secr5et_sauce");
	
		landingPage.getErrorMessage();
		Assert.assertEquals("Epic sadface: Usernam and password do not match any user in this service", landingPage.getErrorMessage());
	}
	
	@Test
	public void productErrorValidation() throws InterruptedException
	{
		String productName = "Sauce Labs Backpack";
		ProductCatalogue productCatalogue = landingPage.loginApplication("performance_glitch_user", "secret_sauce");
		productCatalogue.getProductsList();
		productCatalogue.getProductByName(productName);
		productCatalogue.addToCartButton(productName);
		CartPage cartPage = productCatalogue.clickCartIcon();
		String cartProductNames = cartPage.checkProductNames(productName);
		Assert.assertFalse(cartProductNames.equalsIgnoreCase("Sauce Labs Backpack1"));
	}
}
