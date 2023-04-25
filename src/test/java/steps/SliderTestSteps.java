package steps;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.ios.IOSElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.SliderPage;
import practice.Appium_IOS_Android.BaseIOS;

public class SliderTestSteps extends BaseIOS {
	
	@When("^I click on Slider$")
    public void i_click_on_slider() throws Throwable {
		HomePage h = new HomePage(driver);
		h.SlidersButton.click(); 
		

    }

    @Then("^I verify set value in the slider$")
    public void i_verify_set_value_in_the_slider() throws Throwable {
//    	SliderPage s = new SliderPage(driver);
//    	IOSElement slider = (IOSElement)s.DefaultSlider;
    	IOSElement slider = (IOSElement)driver.findElement(By.xpath("//XCUIElementTypeSlider"));
    	Assert.assertEquals("100%", slider.getAttribute("value"));
    	driver.quit();

    }

    @And("^I set the slider value to (.+)$")
    public void i_set_the_slider_value_to(String value1) throws Throwable {
//    	SliderPage s = new SliderPage(driver);
//    	IOSElement slider = (IOSElement)s.DefaultSlider;
    	IOSElement slider = (IOSElement)driver.findElement(By.xpath("//XCUIElementTypeSlider"));
    	slider.setValue(value1);
		slider.setValue(value1);
		slider.setValue(value1); 

    }

}
