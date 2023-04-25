package practice.Appium_IOS_Android;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseIOS {
	
	public static IOSDriver<IOSElement> driver;
	public static long  start;
	public static IOSDriver<IOSElement> desiredCapabilities(String appName) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis = new FileInputStream("/Users/animesh.sen/eclipse-workspace/Appium_IOS+Android/src/test/java/practice/Appium_IOS_Android/global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.5");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 13 Pro");
		cap.setCapability(MobileCapabilityType.APP, prop.get(appName)); 
		//cap.setCapability(MobileCapabilityType.APP, "/Users/animesh.sen/Desktop/longtap.app"); 
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		cap.setCapability(IOSMobileCapabilityType.WDA_LAUNCH_TIMEOUT, 50000);
		cap.setCapability("commandTimeouts", "12000");
		
		
		driver = new IOSDriver<IOSElement> (new URL("http://localhost:4723/wd/hub"), cap);
		start = System.nanoTime();
		return driver;
	}
	
	public static IOSDriver<IOSElement> browserStackCapabilities() throws IOException {
		// TODO Auto-generated method stub
	
		DesiredCapabilities cap = new DesiredCapabilities();
    	
    	// Set your access credentials
    	cap.setCapability("browserstack.user", "animeshsen_e1atD4");
    	cap.setCapability("browserstack.key", "ViNTxr86EfXoRx2SJgXn");
    	
    	// Set URL of the application under test
    	cap.setCapability("app", "bs://245e75fddfedd6f79b1e2140021773758f4ebf7c");
    	
    	// Specify device and os_version for testing
        cap.setCapability("device", "iPhone 13 Pro");
        cap.setCapability("os_version", "15.4");
        
    	// Set other BrowserStack capabilities
    	cap.setCapability("project", "First Java Project");
    	cap.setCapability("build", "browserstack-build-iOS");
    	cap.setCapability("name", "first_test");
    	
    	cap.setCapability("browserstack.debug", "true"); // to enable visual logs
    	cap.setCapability("browserstack.networkLogs", "true"); // to enable network logs
    	
//    	cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
//		cap.setCapability(IOSMobileCapabilityType.WDA_LAUNCH_TIMEOUT, 50000);
//		cap.setCapability("commandTimeouts", "12000");
    	
    	
    	// Initialise the remote Webdriver using BrowserStack remote URL
    	// and desired capabilities defined above
    	driver = new IOSDriver<IOSElement> (new URL("http://hub-cloud.browserstack.com/wd/hub"), cap);
		return driver;


	}
	
	public static IOSDriver<IOSElement> realDeviceCapabilities(String appName) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis = new FileInputStream("/Users/animesh.sen/eclipse-workspace/Appium_IOS+Android/src/test/java/practice/Appium_IOS_Android/global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "iOS");
		cap.setCapability("platformVersion", "15.5");
		cap.setCapability("deviceName", "Animesh's iPhone 13");
		cap.setCapability("udid", "auto");
		//cap.setCapability("bundleId", "TADigitalDemo.WebDriverAgentRunner");
		cap.setCapability("xcodeOrgId", "F5DWZ4CJMU");
		cap.setCapability("xcodeSigningId", "iPhone Developer");
		cap.setCapability("updatedWDABundleId", "TADigitalDemo.WebDriverAgentRunner");
//		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.5");
//		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Animesh's iPhone 13");
		cap.setCapability(MobileCapabilityType.APP, prop.get(appName)); 
		//cap.setCapability(MobileCapabilityType.APP, "/Users/animesh.sen/Desktop/longtap.app"); 
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		cap.setCapability(IOSMobileCapabilityType.WDA_LAUNCH_TIMEOUT, 50000);
		cap.setCapability("commandTimeouts", "12000");
		//cap.setCapability(MobileCapabilityType.NO_RESET,"true");
		
		

		
		
		driver = new IOSDriver<IOSElement> (new URL("http://localhost:4723/wd/hub"), cap);

		return driver;
	}
	
	public static void scrollToText(String txt)
	{
		HashMap<String, Object> scrollObject = new HashMap<String, Object>();
		scrollObject.put("direction", "down");
		scrollObject.put("name", txt);
		driver.executeScript("mobile:scroll", scrollObject);
	}
	
	public static void getScreenshot (String tcName) throws IOException
	{
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, new File("/Users/animesh.sen/eclipse-workspace/Appium_IOS+Android/Screenshot/screenshot.png"));
	}

}
