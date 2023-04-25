package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class Ecom_ProductsPage {
	
	public Ecom_ProductsPage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@text='ADD TO CART']")
	public List<WebElement> AddToCart;
	
	@FindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	public WebElement Cart;
	


}
