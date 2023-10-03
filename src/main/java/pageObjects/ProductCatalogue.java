package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductCatalogue 
{
	WebDriver driver;
	String productName = "Sauce Labs Backpack";
	
	public ProductCatalogue(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'Products')]")
	WebElement productsHeading;
	
	//List<WebElement> productNames = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
	@FindBy(xpath="//div[@class='inventory_item_name']")
	List<WebElement> productsList;
	
	//By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']")
	@FindBy(xpath="//button[@class='btn btn_primary btn_small btn_inventory']")
	WebElement addToCartButton;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	WebElement cartIcon;
	
	By addToCart = By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']");
	By productList = By.xpath("//div[@class='inventory_item_name']");
	
	
	public void verifyProductCataloguePageHeading()
	{
		//verify 'Products' heading
		String heading = productsHeading.getText();
		System.out.println(heading);
		Assert.assertEquals(heading,"Products");
		System.out.println("3");	
	}
	
	public List<WebElement> getProductsList()
	{
		//getting products names
		List<WebElement> productNames = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		return productsList;
	}
	
	public WebElement getProductByName(String productName)
	{
		WebElement prod = productsList.stream().filter(product->
		product.findElement(productList).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addToCartButton(String productName)
	{
		WebElement prod = getProductByName(productName);
		//addToCartButton.click();
		prod.findElement(addToCart).click();	
	}
	
	public CartPage clickCartIcon()
	{
		//clicking the cart icon
		cartIcon.click();	
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
}
