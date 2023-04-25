package practice.Appium_IOS_Android;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;
import pageObjects.HomePage;
import pageObjects.PickerViewPage;

public class IOS_Scroll extends BaseIOS {

	@Test
	public static void scrollValidation() throws InterruptedException, IOException {

		IOSDriver driver = desiredCapabilities("UIKitCatalog");
		scrollToText("Web View");
		HomePage h = new HomePage(driver);
		PickerViewPage p = new PickerViewPage(driver);
		h.WebView.click();
		Thread.sleep(2000);
		h.BackButton.click();
		h.PickerView.click();
		p.Red.sendKeys("80");
		p.Green.sendKeys("220");
		p.Blue.sendKeys("105");
		String txt = p.Blue.getText();
		System.out.println(txt);
		Assert.assertEquals(txt, "105");	

	}

}
