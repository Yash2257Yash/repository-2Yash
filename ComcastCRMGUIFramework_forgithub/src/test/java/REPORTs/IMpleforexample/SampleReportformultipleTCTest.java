package REPORTs.IMpleforexample;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportformultipleTCTest {
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
	public void CreateContactWith_Org() {

		test = report.createTest("CreateContactWith_Org");

		test.log(Status.INFO, "Login to app");
		test.log(Status.INFO, "Navigate  to contact page ");

		test.log(Status.INFO, "Create contact");

		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "conatact created");
		} else {
			test.log(Status.FAIL, "CreateContactWith_Org is not created ");
		}
	}

	@Test
	public void CreateContact_PHoneno() {

		test = report.createTest("CreateContact_PHoneno");

		test.log(Status.INFO, "Login to app");
		test.log(Status.INFO, "Navigate  to contact page ");

		test.log(Status.INFO, "Create contact");

		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "conatact created");
		} else {
			test.log(Status.FAIL, "CreateContact_PHoneno is not created ");
		}

	}

}
