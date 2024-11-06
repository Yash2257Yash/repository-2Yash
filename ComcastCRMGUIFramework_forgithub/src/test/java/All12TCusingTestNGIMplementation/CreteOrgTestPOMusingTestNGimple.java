package All12TCusingTestNGIMplementation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.webdriverutility.UtilityclassObject;
import com.comcast.crm.objectRepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectRepositoryutility.HomePage;
import com.comcast.crm.objectRepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectRepositoryutility.OrganizationsLinkPage;
import com.crm.generic.Baseutility.BaseTestforRealProject;

public class CreteOrgTestPOMusingTestNGimple extends BaseTestforRealProject {

	@Test(groups = "Smoke Test")
	public void CreateOrg() throws Throwable {
		//read data from excel
		 UtilityclassObject.getTest().log(Status.INFO,"read data from excel");

		String ORGNAME = elib.getDataFromExcel("Createorg", 1, 2) + jlib.getRandomNumber();
		 UtilityclassObject.getTest().log(Status.INFO,"naviaget to org page");

		HomePage hp = new HomePage(driver);
//click on org link
		hp.getOrgLink().click();
		// cclick on create org plus icon
		 UtilityclassObject.getTest().log(Status.INFO,"navigate to create org");

		OrganizationsLinkPage createneworg = new OrganizationsLinkPage(driver);
		createneworg.clickonplus().click();
		// create new org
		 UtilityclassObject.getTest().log(Status.INFO,"create new org");

		CreatingNewOrganizationPage oip = new CreatingNewOrganizationPage(driver);
		oip.createorg(ORGNAME);
//		//click on save
//				oip.getClickonsavebtn().click();
		 UtilityclassObject.getTest().log(Status.INFO,ORGNAME+"to verify ");

		OrganizationInformationPage orginfo = new OrganizationInformationPage(driver);
		String actorg = orginfo.getHeadermsg().getText();
		softobj.softAssertusingboolean(actorg,ORGNAME);
		softobj.assertALL();
		
//		if (actorg.contains(ORGNAME)) {
//			System.out.println(ORGNAME + "is verified");
//		} else {
//			System.out.println(ORGNAME + "is not verified");
//		}

	}

	@Test(groups = "Regression Test")
	public void CreateOrganizationwithIndustryTestpom() throws Throwable {

		String ORGNAME = elib.getDataFromExcel("Createorg", 4, 2) + jlib.getRandomNumber();
		String Industry = elib.getDataFromExcel("Createorg", 4, 3);
		String Type = elib.getDataFromExcel("Createorg", 4, 4);

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
		OrganizationInformationPage verfiyheader = new OrganizationInformationPage(driver);
		String actinf = verfiyheader.getHeadermsg().getText();
		softobj.softAssertusingboolean(actinf, ORGNAME);
		softobj.assertALL();
//		if (actinf.contains(ORGNAME)) {
//			System.out.println(ORGNAME + "is verfied");
//		} else {
//			System.out.println(ORGNAME + "is  not verfied");
//		}

	}

	@Test(groups = "Regression Test")
	public void CreateORGwithPHoneNUm() throws Throwable {
		String ORGNAME = elib.getDataFromExcel("Createorg", 7, 2) + jlib.getRandomNumber();

		String PhoneNumberfromexcel = elib.getDataFromExcel("Createorg", 7, 3);

		// click on org link
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		// cclick on create org plus icon
		OrganizationsLinkPage createneworg = new OrganizationsLinkPage(driver);
		createneworg.clickonplus().click();

		// enter orgname
		CreatingNewOrganizationPage enterorgnamebyusingphno = new CreatingNewOrganizationPage(driver);
		enterorgnamebyusingphno.CreateOrgwithPhonenum(ORGNAME, PhoneNumberfromexcel);
		Thread.sleep(2000);
	}

	@Test(groups = "Regression Test")
	public void DeleteOrganizationTestPom() throws Throwable {
		String ORGNAME = elib.getDataFromExcel("Createorg", 10, 2) + jlib.getRandomNumber();

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

		OrganizationInformationPage orginfo = new OrganizationInformationPage(driver);
		String actorg = orginfo.getHeadermsg().getText();
		softobj.softAssertusingboolean(actorg, ORGNAME);
		softobj.assertALL();
//		if (actorg.contains(ORGNAME)) {
//			System.out.println(ORGNAME + "is verified");
//		} else {
//			System.out.println(ORGNAME + "is not verified");
//		}
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

	}

}
