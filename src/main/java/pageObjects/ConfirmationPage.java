package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage 
{
	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2[@class='complete-header']")
	WebElement actualMess;
	
	public String getConfirmationMessage()
	{
		//verify message
		String actualMessage = actualMess.getText();
		return actualMessage;
	}
}
