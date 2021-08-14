package testRunner;

import org.testng.annotations.AfterClass;

import com.cucumber.listener.Reporter;

import config.ReadPropertyFile;
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;



@CucumberOptions(

		features = "./src/test/java/features",
		glue = { "stepDefinations" }, // path of step definition
		//plugin = {"pretty", "com.cucumber.listener.ExtentCucumberFormatter:Report/Extent_Test_report.html" },
				plugin = {"pretty", "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/Extent_Test_report.html" },
		//plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" },
		//plugin = { "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		//plugin = { "pretty", "html:target/cucumber-reports" },
		monochrome = true,
		dryRun = false, // check all the steps have the definitions and will not execute
		strict = true, // check if any step is not defined in step definition file
		tags="@smoke2")


public class TestRunner extends AbstractTestNGCucumberTests  {
	/*static ReadPropertyFile rp = new ReadPropertyFile();
	@AfterClass
	public static void writeExtentReport() {
		
		//Reporter.loadXMLConfig(rp.readTestData("reportConfigPath"));
	}*/
	

}
