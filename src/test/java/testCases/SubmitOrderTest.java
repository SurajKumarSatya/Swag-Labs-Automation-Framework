package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.ProductCatalogue;
import testComponents.BaseTest;

public class SubmitOrderTest extends BaseTest
{
	WebDriver driver;
	LandingPage landingPage;
	
	@Test
	public void submitOrder() throws InterruptedException 
	{
		//Landing Page
//		landingPage.loginApplication();
		//landingPage = new LandingPage(driver);
		
		
		// product Catalogue
//		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
//		productCatalogue.verifyProductCataloguePageHeading();
//		productCatalogue.getProductsName();
		
	
	}
}
