package com.comcast.crm.ORGPOM.test;

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

public class CreateOrganizationwithIndustryTestpom {
	public static void main(String[] args) throws Throwable {
		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		String URL = flib.getDataFromPropertiesFile("url");
		String UN = flib.getDataFromPropertiesFile("un");
		String PWD = flib.getDataFromPropertiesFile("pwd");
		String BROWSER = flib.getDataFromPropertiesFile("browser");

		String ORGNAME = elib.getDataFromExcel("Createorg", 4, 2) + jlib.getRandomNumber();
		String Industry = elib.getDataFromExcel("Createorg", 4, 3);
		String Type = elib.getDataFromExcel("Createorg", 4, 4);

		WebDriver driver = wlib.browserselect(BROWSER);
		wlib.waitForPageToLoad(driver);
		driver.get(URL);
		// login
		LoginPage lp = new LoginPage(driver);
		lp.logintoApp("admin", "admin");
		// click on orglink
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		// click on plus icon org
		OrganizationsLinkPage orgplus = new OrganizationsLinkPage(driver);
		orgplus.clickonplus().click();
		// createorgwithindustry
		CreatingNewOrganizationPage orgwind = new CreatingNewOrganizationPage(driver);
		orgwind.createorgwithIndstrywithtype(ORGNAME, Industry, Type);
//verify header
		OrganizationInformationPage verfiyheader=new OrganizationInformationPage(driver);
		String actinf = verfiyheader.getHeadermsg().getText();
		if(actinf.contains(ORGNAME))
		{
			System.out.println(ORGNAME+"is verfied");
		}
		else		{
			System.out.println(ORGNAME+"is  not verfied");
		}
		hp.logout();
		wlib.quitwindow(driver);
	}

}
