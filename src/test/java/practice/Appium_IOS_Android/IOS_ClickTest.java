package practice.Appium_IOS_Android;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;
import pageObjects.AlertViewsPage;
import pageObjects.HomePage;

public class IOS_ClickTest extends BaseIOS {
	
	@Test(dataProvider = "getData", dataProviderClass = TestData.class)
	public static void totalValidation(String data) throws InterruptedException, IOException {
		
		IOSDriver driver = desiredCapabilities("UIKitCatalog");
		HomePage h = new HomePage (driver);
		AlertViewsPage av = new AlertViewsPage(driver);
		h.AlertViews.click();
		av.TextButton.click();
		av.TextField.sendKeys(data);
		av.OkPopUp.click();
		av.ConfirmButton.click();
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

}
