package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class PickerViewPage {
	
	public PickerViewPage(IOSDriver<IOSElement> driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//XCUIElementTypePickerWheel[@name='Red color component value']")
	public WebElement Red;
	
	@FindBy(xpath="//XCUIElementTypePickerWheel[@name='Green color component value']")
	public WebElement Green;
	
	@FindBy(xpath="//XCUIElementTypePickerWheel[@name='Blue color component value']")
	public WebElement Blue;
	
	

}
