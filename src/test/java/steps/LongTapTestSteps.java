package steps;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pageObjects.LongTapPage;
import practice.Appium_IOS_Android.BaseIOS;

public class LongTapTestSteps extends BaseIOS {
	
    @When("^I longpress on LongTap button$")
    public void i_longpress_on_longtap_button() throws Throwable {
    	//LongTapPage l = new LongTapPage(driver);
    	//TouchAction t = new TouchAction(driver);
		//t.longPress(longPressOptions().withElement(element(l.LongTapButton)).withDuration(ofSeconds(2))).release().perform();
    	WebElement longtap = driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Long tap']"));
		TouchAction t = new TouchAction(driver);
		t.longPress(longPressOptions().withElement(element(longtap)).withDuration(ofSeconds(2))).release().perform();
		Thread.sleep(3000); 
    	

    }

    @And("^I disable Name option$")
    public void i_disable_name_option() throws Throwable {
    	//LongTapPage l = new LongTapPage(driver);
    	TouchAction t = new TouchAction(driver);
    	//t.tap(tapOptions().withElement(element(l.NameButton))).perform();
    	WebElement name = driver.findElement(By.xpath("(//XCUIElementTypeSwitch)[1]"));
    	t.tap(tapOptions().withElement(element(name))).perform(); 

    }

    @And("^I disable Email option$")
    public void i_disable_email_option() throws Throwable {
    	//LongTapPage l = new LongTapPage(driver);
    	TouchAction t = new TouchAction(driver);
    	//t.tap(tapOptions().withElement(element(l.EmailButton))).perform();
    	WebElement email = driver.findElement(By.xpath("(//XCUIElementTypeSwitch)[2]"));
    	t.tap(tapOptions().withElement(element(email))).perform();	 

    }

}
