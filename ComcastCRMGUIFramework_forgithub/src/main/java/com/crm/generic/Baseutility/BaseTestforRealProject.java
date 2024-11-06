package com.crm.generic.Baseutility;

/**
 * @author YASHAWANTH K M
 */
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.databaseutility.DatabaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityclassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectRepositoryutility.HomePage;
import com.comcast.crm.objectRepositoryutility.LoginPage;

import AssertUtility.HardAssertCalling;
import AssertUtility.SoftAssertCalling;

public class BaseTestforRealProject {
	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	public SoftAssertCalling softobj = new SoftAssertCalling();
	public HardAssertCalling hardobj = new HardAssertCalling();

	public DatabaseUtility dlib = new DatabaseUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public FileUtility flib = new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public JavaUtility jlib = new JavaUtility();

	@BeforeSuite(groups = { "Smoke Test", "Regression Test" })
	public void BeforeSuite() throws Throwable {

		dlib.getDbconnection();
		System.out.println("executed BeforeSuite++=========connect to db and report config");

	}

	@Parameters("BROWSER")
	@BeforeClass(groups = { "Smoke Test", "Regression Test" })
	public void BeforeClass(@Optional("edge") String browser) throws Throwable {
		String BROWSER = browser;

		// flib.getDataFromPropertiesFile("browser");
		driver = wlib.browserselect(BROWSER);
		sdriver = driver;
		UtilityclassObject.setDriver(driver);

		System.out.println("executed BeforeClass====Launch the brow");
	}

//	@BeforeClass(groups = {"Smoke Test","Regression Test"})
//	public void BeforeClass() throws Throwable {
//		String BROWSER =flib.getDataFromPropertiesFile("browser");
//		 driver = wlib.browserselect(BROWSER);
//		 sdriver=driver;
//		System.out.println("executed BeforeClass====Launch the brow");
//	}

	@BeforeMethod(groups = { "Smoke Test", "Regression Test" })
	public void executeBefore() throws Throwable {
		String URL = flib.getDataFromPropertiesFile("url");
		String UN = flib.getDataFromPropertiesFile("un");

		String PWD = flib.getDataFromPropertiesFile("pwd");

		LoginPage lp = new LoginPage(driver);
		lp.logintoApp(URL, UN, PWD);
		System.out.println("executed beforemethod=======login");
	}

	@AfterMethod(groups = { "Smoke Test", "Regression Test" })
	public void executeAfter() throws Throwable {

		HomePage hp = new HomePage(driver);
		hp.logout();

		System.out.println("executed Aftermethod=====logout");
	}

	@AfterClass(groups = { "Smoke Test", "Regression Test" })
	public void Afterclass() {
		wlib.quitwindow(driver);

		System.out.println("executed Afterclass===close the brow");
	}

	@AfterSuite(groups = { "Smoke Test", "Regression Test" })
	public void AfterSuite() throws Throwable {
		dlib.closeDbconnection();
		System.out.println("executed AfterSuite=====connect to db, report backup");

	}

}
