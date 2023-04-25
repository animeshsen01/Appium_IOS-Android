package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

//import com.aventstack.extentreports.gherkin.model.Scenario;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.cucumber.java.AfterStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AlertViewsPage;
import pageObjects.HomePage;
import practice.Appium_IOS_Android.BaseIOS;
import io.cucumber.java.Scenario;

public class ClickTestSteps extends BaseIOS{
	
	static long finish;
	static long startPage = 0;
	static long endPage = 0;

	@Given("^I launch the app (.+)$")
    public void i_launch_the_app(String appName) throws Throwable {
		IOSDriver<IOSElement> driver=desiredCapabilities(appName);
		//IOSDriver<IOSElement> driver=realDeviceCapabilities(appName);
		//IOSDriver<IOSElement> driver=browserStackCapabilities();
		 
    }

    @When("^I click on Alert Views$")
    public void i_click_on_alert_views() throws Throwable {
    	HomePage h = new HomePage(driver);
    	finish = System.nanoTime(); 
    	float timeElapsed = finish - BaseIOS.start;
    	
    	h.AlertViews.click();  
    	startPage = System.nanoTime(); 
    	
    	System.out.println("The application load time is : "+timeElapsed/1000000+" milliseconds");
    	

    }

    @Then("^I verify the message$")
    public void i_verify_the_message() throws Throwable {
    	AlertViewsPage av = new AlertViewsPage(driver);
    	Thread.sleep(2000);
		String txt = av.ValidationMessage.getText();
		if(txt.contains("message"))
		{
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(false);
		}
		av.ConfirmPopUp.click();

    }

    @And("^I click on Text Field$")
    public void i_click_on_text_field() throws Throwable {
    	AlertViewsPage av = new AlertViewsPage(driver);
    	endPage = System.nanoTime(); 
    	float pageLoadTime = endPage - startPage;
    	System.out.println("The page load time is : "+pageLoadTime/1000000+" milliseconds");
		av.TextButton.click();

    }

    @And("^I pass the value (.+)$")
    public void i_pass_the_value(String data) throws Throwable {
    	AlertViewsPage av = new AlertViewsPage(driver);
		av.TextField.sendKeys(data);
		av.OkPopUp.click();

    }

    @And("^I click on Confirm$")
    public void i_click_on_confirm() throws Throwable {
    	AlertViewsPage av = new AlertViewsPage(driver);
		av.ConfirmButton.click();

    }
    
    @AfterStep
	public void addScreenshot(Scenario scenario){

		//validate if scenario has failed
		if(scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "image"); 
		}
		
	}


}
