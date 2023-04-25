package practice.Appium_IOS_Android;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;


public class IOS_LongTap extends BaseIOS {

	@Test
	public static void longTapValidation() throws InterruptedException, IOException {

		IOSDriver driver = desiredCapabilities("LongTap");
		WebElement longtap = driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Long tap']"));
		TouchAction t = new TouchAction(driver);
		t.longPress(longPressOptions().withElement(element(longtap)).withDuration(ofSeconds(2))).release().perform();
		Thread.sleep(3000);
		WebElement name = driver.findElement(By.xpath("(//XCUIElementTypeSwitch)[1]"));
		WebElement email = driver.findElement(By.xpath("(//XCUIElementTypeSwitch)[2]"));
		t.tap(tapOptions().withElement(element(name))).perform();
		t.tap(tapOptions().withElement(element(email))).perform();	

	}

}
