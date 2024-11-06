package com.comcast.crm.ORGPOM.test;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectRepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectRepositoryutility.HomePage;
import com.comcast.crm.objectRepositoryutility.LoginPage;
import com.comcast.crm.objectRepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectRepositoryutility.OrganizationsLinkPage;

public class CreateOrganizationTestPom {
	public static void main(String[] args) throws Throwable {
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();

		String URL = flib.getDataFromPropertiesFile("url");
		String BROWSER = flib.getDataFromPropertiesFile("browser");
		String UN = flib.getDataFromPropertiesFile("un");
		String PWD = flib.getDataFromPropertiesFile("pwd");

		
		String ORGNAME = elib.getDataFromExcel("Createorg", 1, 2) + jlib.getRandomNumber();
		
		WebDriver driver = wlib.browserselect(BROWSER);
		// wlib.Screenrecorderstart();
		// wlib.MaximiseBrowser(driver);
		wlib.waitForPageToLoad(driver);
		driver.get(URL);
		// login
		// LoginPage lp=PageFactory.initElements( driver,LoginPage.class);
//		lp.getUsernameEdt().sendKeys("admin");
//		lp.getPasswordEdt().sendKeys("admin");
//		lp.getLoginBtn().click();
		LoginPage lp = new LoginPage(driver);
		lp.logintoApp("admin", "admin");
		// Navigate to Organization
		HomePage hp = new HomePage(driver);
//click on org link
		hp.getOrgLink().click();
		// cclick on create org plus icon
		OrganizationsLinkPage createneworg = new OrganizationsLinkPage(driver);
		createneworg.clickonplus().click();
		// create new org
		CreatingNewOrganizationPage oip = new CreatingNewOrganizationPage(driver);
		oip.createorg(ORGNAME);
		//click on save
				oip.getClickonsavebtn().click();


		OrganizationInformationPage orginfo = new OrganizationInformationPage(driver);
		String actorg = orginfo.getHeadermsg().getText();
		if (actorg.contains(ORGNAME)) {
			System.out.println(ORGNAME + "is verified");
		} else {
			System.out.println(ORGNAME + "is not verified");
		}
		Thread.sleep(2000);
		hp.logout();


		wlib.quitwindow(driver);

	}

}
