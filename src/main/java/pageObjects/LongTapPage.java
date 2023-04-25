package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class LongTapPage {
	
	public LongTapPage(IOSDriver<IOSElement> driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//XCUIElementTypeButton[@name='Long tap']")
	public WebElement LongTapButton;
	
	@FindBy(xpath="(//XCUIElementTypeSwitch)[1]")
	public WebElement NameButton;
	
	@FindBy(xpath="(//XCUIElementTypeSwitch)[2]")
	public WebElement EmailButton;
	
}
