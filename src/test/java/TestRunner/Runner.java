package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { ".\\Features\\Customers.feature"
		/* ".\\Features\\LoginFeature.feature" */ }, glue = "StepDefinition", dryRun = false, monochrome = true, plugin = {
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
public class Runner extends AbstractTestNGCucumberTests {

}
