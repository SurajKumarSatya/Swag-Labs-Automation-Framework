package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LandingPage 
{
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//driver.findElement(By.id("user-name")).sendKeys("standard_user");
	@FindBy(id="user-name")
	WebElement username;
	
	//driver.findElement(By.id("password")).sendKeys("secret_sauce");
	@FindBy(id="password")
	WebElement passwordEle;
	
	//driver.findElement(By.id("login-button")).click();
	@FindBy(id="login-button")
	WebElement loginBtn;
	
	@FindBy(xpath="//h3[@data-test='error']")
	WebElement loginErrorMessage;
	
	public void goTo()
	{
		driver.get("https://www.saucedemo.com/");
	}
	
	public ProductCatalogue loginApplication(String email, String password) throws InterruptedException
	{
		username.sendKeys(email);
		passwordEle.sendKeys(password);
		loginBtn.click();
		Thread.sleep(3000);
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
		
	}
	
	public String getErrorMessage()
	{
		return loginErrorMessage.getText();
	}
	
	public String verifyTitles()
	{
		//verify title
		String actualTitle = driver.getTitle();
		return actualTitle;
	}

}
