package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class AlertViewsPage {
	
	public AlertViewsPage(IOSDriver<IOSElement> driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="Text Entry")
	public WebElement TextButton;
	
	@FindBy(xpath="//XCUIElementTypeCell")
	public WebElement TextField;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='OK']")
	public WebElement OkPopUp;
	
	@FindBy(id="Confirm / Cancel")
	public WebElement ConfirmButton;
	
	@FindBy(id="Confirm")
	public WebElement ConfirmPopUp;
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='A message should be a short, complete sentence.']")
	public WebElement ValidationMessage;

}
