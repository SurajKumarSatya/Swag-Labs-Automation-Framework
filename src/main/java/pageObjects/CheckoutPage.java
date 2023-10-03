package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage 
{
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="first-name")
	WebElement firstName;
	
	@FindBy(id="last-name")
	WebElement lastName;
	
	@FindBy(id="postal-code")
	WebElement postalCode;
	
	@FindBy(id="continue")
	WebElement continueBtn;
	
	public void enterInfo()
	{
		firstName.sendKeys("Ravi");
		lastName.sendKeys("Kumar");
		postalCode.sendKeys("000000");
	}
	
	public OverviewPage clickContinueBtn()
	{
		//clicking 'Continue' button
		continueBtn.click();
		OverviewPage overviewPage = new OverviewPage(driver);
		return overviewPage;
	}
}
