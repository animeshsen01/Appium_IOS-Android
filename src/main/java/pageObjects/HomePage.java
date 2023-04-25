package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class HomePage {
	
	public HomePage(IOSDriver<IOSElement> driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Alert Views']")
	public WebElement AlertViews;
	
	@FindBy(id="Web View")
	public WebElement WebView;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='UIKitCatalog']")
	public WebElement BackButton;
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Picker View']")
	public WebElement PickerView;
	
	@FindBy(id="Sliders")
	public WebElement SlidersButton;

}
