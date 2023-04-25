package practice.Appium_IOS_Android;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseAndroid {
	
	public static AndroidDriver<AndroidElement> driver;
	public static long  start;
	
	public static AndroidDriver<AndroidElement> desiredCapabilities (String appName) throws IOException, InterruptedException {
		
		FileInputStream fis = new FileInputStream("/Users/animesh.sen/eclipse-workspace/Appium_IOS+Android/src/test/java/practice/Appium_IOS_Android/global.properties");
		Properties prop =  new Properties ();
		prop.load(fis);
		
		//Creating object of DesiredCapabilities to store Device Name, App etc
		DesiredCapabilities cap = new DesiredCapabilities ();
		
		//On Android Emulator
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "AnimeshEmulator");

		//Setting up the App
		cap.setCapability(MobileCapabilityType.APP, prop.get(appName));
		//Setting up Automation Framework
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		
		//Creating driver object of AndroidDriver and passing the Port number
		
        driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"),cap);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		start = System.nanoTime();

		return driver;

	}
	
public static AndroidDriver<AndroidElement> realDeviceCapabilities (String appName) throws IOException, InterruptedException {
		
		FileInputStream fis = new FileInputStream("/Users/animesh.sen/eclipse-workspace/Appium_IOS+Android/src/test/java/practice/Appium_IOS_Android/global.properties");
		Properties prop =  new Properties ();
		prop.load(fis);
		
		//Creating object of DesiredCapabilities to store Device Name, App etc
		DesiredCapabilities cap = new DesiredCapabilities ();

		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "R9ZR306DM0T");
		cap.setCapability(MobileCapabilityType.VERSION, "11.0");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

		
		//Setting up the App
		cap.setCapability(MobileCapabilityType.APP, prop.get(appName));
		
		//Creating driver object of AndroidDriver and passing the Port number
		
        driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"),cap);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		start = System.nanoTime();

		return driver;

	}
	
	public static  AndroidDriver<AndroidElement> browserStackCapabilities () throws IOException, InterruptedException {
		DesiredCapabilities caps = new DesiredCapabilities();
    	
    	// Set your access credentials
    	caps.setCapability("browserstack.user", "animeshsen_e1atD4");
    	caps.setCapability("browserstack.key", "ViNTxr86EfXoRx2SJgXn");
    	// Set your access credentials 
//    	caps.setCapability("browserstack.user", BROWSERSTACK_USERNAME);
//    	caps.setCapability("browserstack.key", BROWSERSTACK_ACCESS_KEY);
    	
    	
    	// Set URL of the application under test
    	caps.setCapability("app", "bs://733bb1fb6e68d98a0e89a58da2f07a1b7b5d20f0");
    	
    	// Specify device and os_version for testing
    	caps.setCapability("device", "Google Pixel 3");
    	caps.setCapability("os_version", "9.0");
    	
    	//caps.setCapability("browserstack.local", "true");
    	
    	caps.setCapability("project", "Native App Automation Project");
    	caps.setCapability("build", "browserstack-build-Android");
    	caps.setCapability("name", "Validate Cart");
       
    	caps.setCapability("browserstack.debug", "true"); // to enable visual logs
    	caps.setCapability("browserstack.networkLogs", "true"); // to enable network logs
    	
    	// Initialise the remote Webdriver using BrowserStack remote URL
    	// and desired capabilities defined above
    	 driver = new AndroidDriver<AndroidElement>(
        		new URL("http://hub.browserstack.com/wd/hub"), caps);
        
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;

	}

	public static void getScreenshot(String tcName) throws IOException {
		// TODO Auto-generated method stub
		File scr = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, new File(System.getProperty("user.dir")+"\\Reports\\"+tcName+".png"));
	}
	
	public void scrollToText(String text)
	{
	     driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));");
	}

}
