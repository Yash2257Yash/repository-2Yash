package com.comcast.crm.contacttestPOM;

import org.openqa.selenium.WebDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectRepositoryutility.ContactLinkPage;
import com.comcast.crm.objectRepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectRepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectRepositoryutility.HomePage;
import com.comcast.crm.objectRepositoryutility.LoginPage;
import com.comcast.crm.objectRepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectRepositoryutility.OrganizationsLinkPage;
import com.comcast.crm.objectRepositoryutility.PlusOFSelectingorgPage;
import com.comcast.crm.objectRepositoryutility.contactverifyinformationPage;

public class CreatecontactWithOrganizationTestpom {
	public static void main(String[] args) throws Throwable {

//fro random number
		JavaUtility jlib = new JavaUtility();

		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		String URL = flib.getDataFromPropertiesFile("url");
		String UN = flib.getDataFromPropertiesFile("un");
		String PWD = flib.getDataFromPropertiesFile("pwd");
		String BROWSER = flib.getDataFromPropertiesFile("browser");

		String CONTACTLN = elib.getDataFromExcel("Contact", 7, 3) + jlib.getRandomNumber();

		String ORGNAME = elib.getDataFromExcel("Contact", 7, 2) + jlib.getRandomNumber();

		WebDriver driver = wlib.browserselect(BROWSER);
		wlib.waitForPageToLoad(driver);
		driver.get(URL);
		// login
		LoginPage lp = new LoginPage(driver);
		lp.logintoApp("admin", "admin");
		// click on Org link
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		// to click on plus icon
		OrganizationsLinkPage plusicon = new OrganizationsLinkPage(driver);
		plusicon.clickonplus().click();
		// create new org
		CreatingNewOrganizationPage oip = new CreatingNewOrganizationPage(driver);
		oip.createorg(ORGNAME);
		oip.getClickonsavebtn().click();
		
		OrganizationInformationPage orginfo = new OrganizationInformationPage(driver);
		String actorg = orginfo.getHeadermsg().getText();
		if (actorg.contains(ORGNAME)) {
			System.out.println(ORGNAME + "is verified");
		} else {
			System.out.println(ORGNAME + "is not verified");
		}
		// click on Org link
		hp.Conatctlink().click();
		
		
		//click on plus icon
		ContactLinkPage clink=new ContactLinkPage(driver);
		clink.getCreateNeworgbtn().click();
		
		//enter last name
		CreateNewContactPage plusorg=new CreateNewContactPage(driver);
		plusorg.enterlNandsave(CONTACTLN);

		
		
		// select created select from here
		CreateNewContactPage createorg = new CreateNewContactPage(driver);
		createorg.getorgPLusIcon().click();
		wlib.switchToTabOnurl(driver, "Accounts&action");

		PlusOFSelectingorgPage plusiconclick = new PlusOFSelectingorgPage(driver);
		plusiconclick.searchfororgfrompopupoforg(ORGNAME);
		wlib.switchToTabOnurl(driver, "Contacts&action");
		//CreateNewContactPage savethepro = new CreateNewContactPage(driver);

		

		String startDate = jlib.getSystemDateYYYYDDMM();

		String enddate = jlib.getRequiredDateYYYYDDMM(30);

		plusorg.clearandsetthedate(startDate,enddate);
		plusorg.getClickonsavebtn().click();
		

		
		contactverifyinformationPage cvi=new contactverifyinformationPage(driver);
		String orgNameverify = cvi.getOrgName().getText();
		Thread.sleep(2000);

		if (orgNameverify.contains(ORGNAME)) {
			System.out.println(ORGNAME + " contact verfied sucessfully");
		} else {
			System.out.println(ORGNAME + " contact not  verfied ");
		}
//
//		// to verify startdate
		String startverifytext = cvi.getStartDate().getText();
		if (startverifytext.equals(startDate)) {
			System.out.println(startDate + "  verfied sucessfully");
		} else {
			System.out.println(startDate + "  not  verfied ");
		}
		
		

		// to verify enddate
	String enddateverify =  cvi.getendDate().getText();
		
		if (enddateverify.equals(enddate)) {
			System.out.println(enddate + " verfied sucessfully");
		} else {
			System.out.println(enddate + " not  verfied ");
		}
		
		
		// verify lastname
				String LNverifytext = cvi.getln().getText();

				if (LNverifytext.equals(CONTACTLN)) {
					System.out.println(CONTACTLN + " contact verfied sucessfully");
				} else {
					System.out.println(CONTACTLN + " contact not  verfied ");
				}
		
		

	wlib.quitwindow(driver);
}

}
