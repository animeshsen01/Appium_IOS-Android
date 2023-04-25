package steps;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.PickerViewPage;
import practice.Appium_IOS_Android.BaseIOS;

public class ScrollTestSteps extends BaseIOS{
	
	 @When("^I scroll to (.+)$")
	    public void i_scroll_to(String scrollpoint) throws Throwable {
		 scrollToText(scrollpoint);

	    }
	    
	    @Then("^I verify the values set for (.+) (.+) and (.+)$")
	    public void i_verify_the_values_set_for_and(String red, String green, String blue) throws Throwable {
	    	PickerViewPage p = new PickerViewPage(driver);
	    	String txt1 = p.Red.getText();
	    	String txt2 = p.Green.getText();
	    	String txt3 = p.Blue.getText();
			Assert.assertEquals(txt1, red);
			Assert.assertEquals(txt2, green);
			Assert.assertEquals(txt3, blue);
			driver.quit();
	    }

	    @And("^I click on Web View$")
	    public void i_click_on_web_view() throws Throwable {
	    	HomePage h = new HomePage(driver);
	    	h.WebView.click();
			Thread.sleep(2000);

	    }

	    @And("^I navigate back to homepage$")
	    public void i_navigate_back_to_homepage() throws Throwable {
	    	HomePage h = new HomePage(driver);
	    	h.BackButton.click();

	    }

	    @And("^I click on Picker View$")
	    public void i_click_on_picker_view() throws Throwable {
	    	HomePage h = new HomePage(driver);
	    	h.PickerView.click();

	    }

	    @And("^I set the values for (.+) (.+) and (.+)$")
	    public void i_set_the_values_for_and(String red, String green, String blue) throws Throwable {
	    	PickerViewPage p = new PickerViewPage(driver);
	    	p.Red.sendKeys(red);
			p.Green.sendKeys(green);
			p.Blue.sendKeys(blue);

	    }


}
