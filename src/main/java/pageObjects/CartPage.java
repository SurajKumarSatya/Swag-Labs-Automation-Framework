package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage 
{
	WebDriver driver;
	
	
	public CartPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//div[@class='inventory_item_name']")
	WebElement checkProductName;
	
	@FindBy(id="checkout")
	WebElement checkout;
	
	
	
	public String checkProductNames(String productName)
	{
		//check the product name in cart page
		String cartProductName = checkProductName.getText();
		return cartProductName;
		
		//Assert.assertEquals(productName, cartProductName);			
	}
	
	public CheckoutPage clickCheckoutBtn()
	{
		checkout.click();
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}
}
