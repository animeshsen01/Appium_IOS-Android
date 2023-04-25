package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class Ecom_CartPage {
	
	public Ecom_CartPage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="com.androidsample.generalstore:id/productPrice")
	public List<WebElement> amount;
	
	@FindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	public WebElement totalAmount;
	
	
	@FindBy(xpath="//*[@text='Visit to the website to complete purchase']")
	public WebElement VisitWebSite;


}
