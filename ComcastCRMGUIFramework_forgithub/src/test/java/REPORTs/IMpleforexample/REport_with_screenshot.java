package REPORTs.IMpleforexample;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class REport_with_screenshot {
	public ExtentReports report;
	public ExtentSparkReporter spark;
	public ExtentTest test;
	

	@BeforeSuite
	public void configBS() {

		// spark report config
		spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Automation Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		// add env info and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("operating system", "windows_10");
		report.setSystemInfo("BROWSER", "chrome");
	}

	@AfterSuite
	public void configAS() {
		// take backup
		report.flush();
	}
	@Test
	public void Create_org_with_sc()
	{
	
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888");
	TakesScreenshot tss=(TakesScreenshot)driver;
	String filepath=tss.getScreenshotAs(OutputType.BASE64);
	
	
	ExtentTest test=report.createTest("Create_org_with_sc");
	if("Hdfc".equals("HDFC")) {
		test.log(Status.PASS, "Create_org_with_sc is pass");
	}
	else
	{
		test.addScreenCaptureFromBase64String(filepath,"ErrorFile");
	}
	
	
	
	
	}

}
