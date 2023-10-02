package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
	//	String expectedMessage = "Thank you for your order!";
		String actualMessage = actualMess.getText();
		return actualMessage;
	}
}
