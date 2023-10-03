package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage 
{
	WebDriver driver;
	
	public OverviewPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='summary_info_label summary_total_label']")
	WebElement totalPrice;
	
	@FindBy(id="finish")
	WebElement finishBtn;
	
	public void getPrice()
	{
		//get Total Price
		String price = totalPrice.getText();
		System.out.println(price);
	}
	
	public ConfirmationPage clickFinishBtn()
	{
		//click the 'Finish' button
		finishBtn.click();
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		return confirmationPage;
	}
}
