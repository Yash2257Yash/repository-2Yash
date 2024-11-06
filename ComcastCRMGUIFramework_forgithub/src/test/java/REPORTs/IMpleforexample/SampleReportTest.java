package REPORTs.IMpleforexample;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest {
	@Test
	public void CreateContact() {
		//spark report config
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Automation Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		//add env info and create test
		ExtentReports report =new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS","windows_10");
		report.setSystemInfo("BROWSER","chrome");
	ExtentTest	test=report.createTest("CreateContactTest");

	test.log(Status.INFO,"Login to app");
	test.log(Status.INFO,"Navigate  to contact page ");

	test.log(Status.INFO,"Create contact");

		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS,"conatact created");
		} else {
			test.log(Status.FAIL,"Contact is not created ");
		}
		//take backup
		report.flush();

	}

}
