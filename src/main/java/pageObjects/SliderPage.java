package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class SliderPage {
	
	public SliderPage(IOSDriver<IOSElement> driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//XCUIElementTypeSlider")
	public WebElement DefaultSlider;
	
}
