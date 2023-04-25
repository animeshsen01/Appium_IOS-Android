package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Ecom_SignInPage {
	
	public Ecom_SignInPage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//android.widget.EditText[@text='Enter name here']")
	public WebElement Name;
	
	@FindBy(xpath="//android.widget.Button[contains(@text,'Shop')]")
	public WebElement SignInButton;
	
	@FindBy(id="android:id/text1")
	public WebElement countrySelectionDropdown;
	
	@FindBy(xpath="//*[@text='India']")
	public WebElement selectIndia;
	
	

	
	

	


}
