package com.comcast.crm.ORGPOM.test;

import org.openqa.selenium.WebDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectRepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectRepositoryutility.HomePage;
import com.comcast.crm.objectRepositoryutility.LoginPage;
import com.comcast.crm.objectRepositoryutility.OrganizationsLinkPage;

public class CreateOrganizationwithPhonenumTestpom {
	public static void main(String[] args) throws Throwable {
		JavaUtility jlib = new JavaUtility();
		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		String URL = flib.getDataFromPropertiesFile("url");
		String UN = flib.getDataFromPropertiesFile("un");
		String PWD = flib.getDataFromPropertiesFile("pwd");
		String BROWSER = flib.getDataFromPropertiesFile("browser");

		String ORGNAME = elib.getDataFromExcel("Createorg", 7, 2) + jlib.getRandomNumber();

		String PhoneNumberfromexcel = elib.getDataFromExcel("Createorg", 7, 3);

		WebDriver driver = wlib.browserselect(BROWSER);

		wlib.waitForPageToLoad(driver);
		driver.get(URL);
		// login to app
		LoginPage lp = new LoginPage(driver);
		lp.logintoApp("admin", "admin");

		// click on org link
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		// cclick on create org plus icon
		OrganizationsLinkPage createneworg = new OrganizationsLinkPage(driver);
		createneworg.clickonplus().click();
		

		// enter orgname
		CreatingNewOrganizationPage enterorgnamebyusingphno = new CreatingNewOrganizationPage(driver);
		enterorgnamebyusingphno.CreateOrgwithPhonenum(ORGNAME, PhoneNumberfromexcel);
Thread.sleep(3000);
		hp.logout();
		wlib.quitwindow(driver);
	}

}
