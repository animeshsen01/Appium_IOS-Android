package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Ecom_CartPage;
import pageObjects.Ecom_ProductsPage;
import pageObjects.Ecom_SignInPage;
import practice.Appium_IOS_Android.BaseAndroid;
import practice.Appium_IOS_Android.BaseIOS;

public class ValidateCartSteps extends BaseAndroid {
	
	static long finish;
	static long startPage;
	static long endPage;
	static long startPage2;
	static long endPage2;
	
	 	@Given("^I launch the android app (.+)$")
	    public void i_launch_the_android_app(String appname) throws Throwable {
	 		AndroidDriver<AndroidElement> driver = desiredCapabilities(appname);
	 		//AndroidDriver<AndroidElement> driver = browserStackCapabilities();
	 		//AndroidDriver<AndroidElement> driver = realDeviceCapabilities(appname);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	    }

	    @When("^I sign in as (.+)$")
	    public void i_sign_in_as(String name) throws Throwable {
	    	Ecom_SignInPage e = new Ecom_SignInPage(driver);
			e.Name.sendKeys(name);
			driver.hideKeyboard();
			Thread.sleep(2000);
			startPage=System.nanoTime();
			e.SignInButton.click();
			

	    }

	    @Then("^I validate the total amount$")
	    public void i_validate_the_total_amount() throws Throwable {
	    	Ecom_CartPage c = new Ecom_CartPage(driver);
//	    	endPage2 = System.nanoTime();
//	    	float pageLoad2 = endPage2 - startPage2;
//	    	System.out.println("The page load time of Cart is : "+pageLoad2/1000000+" milliseconds");
			double amount1 = Double.parseDouble(c.amount.get(0).getText().substring(1));
			double amount2 = Double.parseDouble(c.amount.get(1).getText().substring(1));
			double sum = amount1 + amount2;
			double total = Double.parseDouble(c.totalAmount.getText().substring(1));
			Assert.assertEquals(sum, total);
			driver.quit();

	    }

	    @And("^I add products to the cart$")
	    public void i_add_products_to_the_cart() throws Throwable {
	    	Ecom_ProductsPage p = new Ecom_ProductsPage(driver);
	    	endPage = System.nanoTime();
	    	float pageLoad = endPage - startPage;
	    	System.out.println("The page load time of Products is : "+pageLoad/1000000+" milliseconds");
			p.AddToCart.get(0).click();
			p.AddToCart.get(0).click();
			Thread.sleep(3000);

	    }

	    @And("^I navigate to Cart$")
	    public void i_navigate_to_cart() throws Throwable {
	    	Ecom_ProductsPage p = new Ecom_ProductsPage(driver);
//	    	startPage2=System.nanoTime();
	    	p.Cart.click();
			Thread.sleep(3000);

	    }
	    
	    @And("^I select (.+) from country dropdown$")
	    public void i_select_from_country_dropdown(String countryname) throws Throwable {
	    	Ecom_SignInPage e = new Ecom_SignInPage(driver);
	    	finish = System.nanoTime(); 
	    	float timeElapsed = finish - BaseAndroid.start;
	    	System.out.println("The application load time is : "+timeElapsed/1000000+" milliseconds");
	    	e.countrySelectionDropdown.click();
	    	scrollToText(countryname);
	    	driver.findElement(By.xpath("//*[@text='"+ countryname +"']")).click();
	    }


}
