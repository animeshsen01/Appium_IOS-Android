package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import practice.Appium_IOS_Android.BaseIOS;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features",
		glue = "steps" ,
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
//		tags = "@ValidateCart" )


public class TestRunner {
	

}
