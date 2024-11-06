package com.comcast.crm.listenerUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.webdriverutility.UtilityclassObject;

public class ListenerImplementationclass implements ITestListener, ISuiteListener {
	public ExtentReports report;
	public static ExtentTest test;

	/**
	 * to remove space and : we have to use replace twice
	 */
	String Time = new Date().toString().replace(" ", "_").replace(":", "_");
	// if we want to use this test in every TC make it static

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onStart(suite);

		System.out.println("Report configuration");
		// spark report config
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report" + Time + ".html");
		spark.config().setDocumentTitle("CRM Automation Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		// add env info and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "windows_10");
		report.setSystemInfo("BROWSER", "chrome");
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onFinish(suite);
		System.out.println("Report Backup");
		// take backup
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		System.out.println("======" + result.getMethod().getMethodName() + "==Start===");
		test = report.createTest(result.getMethod().getMethodName());
		UtilityclassObject.setTest(test);

		test.log(Status.PASS, result.getMethod().getMethodName() + "===>STARTED====>");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		System.out.println("======" + result.getMethod().getMethodName() + "==End===");
		test.log(Status.PASS, result.getMethod().getMethodName() + "====>COMPLETED====>");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		String TestcaseName = result.getMethod().getMethodName();
		TakesScreenshot edriver = (TakesScreenshot) UtilityclassObject.getDriver();
//		File srcfile = edriver.getScreenshotAs(OutputType.FILE);

		String filepath = edriver.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(filepath, TestcaseName + Time);
		test.log(Status.FAIL, result.getMethod().getMethodName() + "====>FAILED===>");
		test.log(Status.FAIL, result.getThrowable());

//		try {
//			FileUtils.copyFile(srcfile, new File("./ScreenShots/" + TestcaseName + "+" + Time + ".png"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			test.addScreenCaptureFromBase64String(filepath, TestcaseName+Time);
//
//		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		test.log(Status.SKIP, result.getMethod().getMethodName() + "====>SKIPPED===>");

		test.log(Status.SKIP, result.getThrowable());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		// take backup
		report.flush();
	}

}
