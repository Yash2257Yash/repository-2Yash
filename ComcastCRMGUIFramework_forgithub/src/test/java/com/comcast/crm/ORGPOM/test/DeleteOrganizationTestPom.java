package com.comcast.crm.ORGPOM.test;

import java.io.FileInputStream;

import org.openqa.selenium.By;
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

public class DeleteOrganizationTestPom {
	public static void main(String[] args) throws Throwable {

		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();

		String URL = flib.getDataFromPropertiesFile("url");
		String BROWSER = flib.getDataFromPropertiesFile("browser");
		String UN = flib.getDataFromPropertiesFile("un");
		String PWD = flib.getDataFromPropertiesFile("pwd");

		FileInputStream fis = new FileInputStream("./TestData/VtigerPrcatice.xlsx");

		String ORGNAME = elib.getDataFromExcel("Createorg", 10, 2) + jlib.getRandomNumber();

		WebDriver driver = wlib.browserselect(BROWSER);
		// wlib.Screenrecorderstart();
		// wlib.MaximiseBrowser(driver);
		wlib.waitForPageToLoad(driver);
		driver.get(URL);

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
		// go back to org page
		hp.getOrgLink().click();

		// search for org
		createneworg.getSaerchEdt().sendKeys(ORGNAME);
		wlib.selectbyVisibleText(createneworg.getSaerchDD(), "Organization Name");
		createneworg.getsearchBtn().click();
		// in dynamic webtable select & delete org
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='" + ORGNAME + "']/../../td[8]/a[text()='del']")).click();
		wlib.switchToAlertAndAccept(driver);

		hp.logout();
		wlib.quitwindow(driver);

	}

}
