package practice.Appium_IOS_Android;
import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import pageObjects.HomePage;
import pageObjects.SliderPage;

public class IOS_Slider extends BaseIOS {

	@Test
	public static void sliderValidation() throws IOException {
		// TODO Auto-generated method stub
		IOSDriver driver = desiredCapabilities("UIKitCatalog");
		HomePage h = new HomePage(driver);
		//SliderPage s = new SliderPage(driver);
		h.SlidersButton.click();
		//driver.findElement(By.id("Sliders")).click();
		//IOSElement slider = (IOSElement)s.DefaultSlider;
		IOSElement slider = (IOSElement)driver.findElement(By.xpath("//XCUIElementTypeSlider"));
		slider.setValue("0%");
		slider.setValue("0.5%");
		slider.setValue("1%");
		
		Assert.assertEquals("100%", slider.getAttribute("value"));

	}

}
