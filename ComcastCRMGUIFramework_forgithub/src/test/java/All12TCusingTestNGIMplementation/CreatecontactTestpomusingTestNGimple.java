package All12TCusingTestNGIMplementation;
/**
 * @author kmyas
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.comcast.crm.objectRepositoryutility.ComposeLinkPage;
import com.comcast.crm.objectRepositoryutility.ContactLinkPage;
import com.comcast.crm.objectRepositoryutility.ContactbyORgofReports;
import com.comcast.crm.objectRepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectRepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectRepositoryutility.EmailLinkPage;
import com.comcast.crm.objectRepositoryutility.HomePage;
import com.comcast.crm.objectRepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectRepositoryutility.OrganizationsLinkPage;
import com.comcast.crm.objectRepositoryutility.PlusOFSelectingorgPage;
import com.comcast.crm.objectRepositoryutility.SelectContactforemailPage;
import com.comcast.crm.objectRepositoryutility.ViewReportsPage;
import com.comcast.crm.objectRepositoryutility.contactverifyinformationPage;
import com.crm.generic.Baseutility.BaseTestforRealProject;

public class CreatecontactTestpomusingTestNGimple extends BaseTestforRealProject {
	@Test(groups = "Smoke Test")
	
	public void CreatecontactTest() throws Throwable {

		// excel connection

		String CONTACTLN = elib.getDataFromExcel("Contact", 1, 2) + jlib.getRandomNumber();

		// click on contact link
		HomePage hp = new HomePage(driver);
		hp.Conatctlink().click();
		// to click on plus icon
		OrganizationsLinkPage plusicon = new OrganizationsLinkPage(driver);
		plusicon.clickonplus().click();
		// enter lastname and click on save button
		CreateNewContactPage enterln = new CreateNewContactPage(driver);
		enterln.enterlNandsave(CONTACTLN);
		enterln.getClickonsavebtn().click();
		// verify lastname
		contactverifyinformationPage coninfo = new contactverifyinformationPage(driver);
		String LNverifytext = coninfo.getln().getText();
		softobj.softAssertusingboolean(LNverifytext,CONTACTLN);
		softobj.assertALL();
//		if (LNverifytext.equals(CONTACTLN)) {
//			System.out.println(CONTACTLN + " contact verfied sucessfully");
//		} else {
//			System.out.println(CONTACTLN + " contact not  verfied ");
//		}

	}

	@Test(groups = "Regression Test")
	public void CreateContactwithOrg() throws Throwable {
		String CONTACTLN = elib.getDataFromExcel("Contact", 7, 3) + jlib.getRandomNumber();

		String ORGNAME = elib.getDataFromExcel("Contact", 7, 2) + jlib.getRandomNumber();

		// click on Org link
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		// to click on plus icon
		OrganizationsLinkPage plusicon = new OrganizationsLinkPage(driver);
		plusicon.clickonplus().click();
		// create new org
		CreatingNewOrganizationPage oip = new CreatingNewOrganizationPage(driver);
		oip.createorg(ORGNAME);

		OrganizationInformationPage orginfo = new OrganizationInformationPage(driver);
		String actorg = orginfo.getHeadermsg().getText();
		softobj.softAssertusingboolean(actorg, CONTACTLN);
//		if (actorg.contains(ORGNAME)) {
//			System.out.println(ORGNAME + "is verified");
//		} else {
//			System.out.println(ORGNAME + "is not verified");
//		}
		// click on Org link
		hp.Conatctlink().click();

		// click on plus icon
		ContactLinkPage clink = new ContactLinkPage(driver);
		clink.getCreateNeworgbtn().click();

		// enter last name
		CreateNewContactPage plusorg = new CreateNewContactPage(driver);
		plusorg.enterlNandsave(CONTACTLN);

		// select created select from here
		CreateNewContactPage createorg = new CreateNewContactPage(driver);
		createorg.getorgPLusIcon().click();
		wlib.switchToTabOnurl(driver, "Accounts&action");

		PlusOFSelectingorgPage plusiconclick = new PlusOFSelectingorgPage(driver);
		plusiconclick.searchfororgfrompopupoforg(ORGNAME);
		wlib.switchToTabOnurl(driver, "Contacts&action");
		// CreateNewContactPage savethepro = new CreateNewContactPage(driver);

		String startDate = jlib.getSystemDateYYYYDDMM();

		String enddate = jlib.getRequiredDateYYYYDDMM(30);

		plusorg.clearandsetthedate(startDate, enddate);
		// plusorg.getClickonsavebtn().click();

		contactverifyinformationPage cvi = new contactverifyinformationPage(driver);
		String orgNameverify = cvi.getOrgName().getText();
		softobj.softAssertusingboolean(orgNameverify, ORGNAME);
//		if (orgNameverify.contains(ORGNAME)) {
//			System.out.println(ORGNAME + " contact verfied sucessfully");
//		} else {
//			System.out.println(ORGNAME + " contact not  verfied ");
//		}
//
//		// to verify startdate
		String startverifytext = cvi.getStartDate().getText();
		softobj.softAssertusingboolean(startverifytext, startDate);
//		if (startverifytext.equals(startDate)) {
//			System.out.println(startDate + "  verfied sucessfully");
//		} else {
//			System.out.println(startDate + "  not  verfied ");
//		}

		// to verify enddate
		String enddateverify = cvi.getendDate().getText();
		softobj.softAssertusingboolean(enddateverify, enddate);

//		if (enddateverify.equals(enddate)) {
//			System.out.println(enddate + " verfied sucessfully");
//		} else {
//			System.out.println(enddate + " not  verfied ");
//		}

		// verify lastname
		String LNverifytext = cvi.getln().getText();
		
		softobj.softAssertusingboolean(LNverifytext, CONTACTLN);
		softobj.assertALL();
//		if (LNverifytext.equals(CONTACTLN)) {
//			System.out.println(CONTACTLN + " contact verfied sucessfully");
//		} else {
//			System.out.println(CONTACTLN + " contact not  verfied ");
//		}

	}

	@Test(groups = "Regression Test")
	public void CreateContactwithSupportDate() throws Throwable {

		String CONTACTLN = elib.getDataFromExcel("Contact", 4, 2) + jlib.getRandomNumber();

		// click on contact link
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
		// to click on plus icon
		OrganizationsLinkPage plusicon = new OrganizationsLinkPage(driver);
		plusicon.clickonplus().click();
		// enter lastname and
		CreateNewContactPage enterln = new CreateNewContactPage(driver);
		enterln.enterlNandsave(CONTACTLN);

		CreateNewContactPage plusorg = new CreateNewContactPage(driver);

		// CreateNewContactPage savethepro = new CreateNewContactPage(driver);

		String startDate = jlib.getSystemDateYYYYDDMM();

		String enddate = jlib.getRequiredDateYYYYDDMM(30);

		plusorg.clearandsetthedate(startDate, enddate);
		// plusorg.getClickonsavebtn().click();

		contactverifyinformationPage cvi = new contactverifyinformationPage(driver);

		// to verify startdate
		String startverifytext = cvi.getStartDate().getText();
		softobj.softAssertusingboolean(startverifytext, startDate);
//		if (startverifytext.equals(startDate)) {
//			System.out.println(startDate + "  verfied sucessfully");
//		} else {
//			System.out.println(startDate + "  not  verfied ");
//		}

		// to verify enddate
		String enddateverify = cvi.getendDate().getText();
		softobj.softAssertusingboolean(enddateverify, enddate);
//		if (enddateverify.equals(enddate)) {
//			System.out.println(enddate + " verfied sucessfully");
//		} else {
//			System.out.println(enddate + " not  verfied ");
//		}

		// verify lastname
		String LNverifytext = cvi.getln().getText();
		softobj.softAssertusingboolean(LNverifytext, CONTACTLN);
		softobj.assertALL();

//		if (LNverifytext.equals(CONTACTLN)) {
//			System.out.println(CONTACTLN + " contact verfied sucessfully");
//		} else {
//			System.out.println(CONTACTLN + " contact not  verfied ");
//		}

	}

	@Test(groups = "Regression Test")
	public void CreateConatctwithEmail() throws Throwable {
		// excel connection
		String CONTACTLN = elib.getDataFromExcel("Contact", 1, 2) + jlib.getRandomNumber();

		String EMAIL = elib.getDataFromExcel("Contact", 1, 3);

		String updatedemail = CONTACTLN + EMAIL;
		// launch browser

		HomePage hp = new HomePage(driver);

		hp.Conatctlink().click();
		// to click on plus icon
		OrganizationsLinkPage plusicon = new OrganizationsLinkPage(driver);
		plusicon.clickonplus().click();
		// enter lastname
		CreateNewContactPage createnewcon = new CreateNewContactPage(driver);
		createnewcon.contactwithemail(CONTACTLN, updatedemail);
		// verify lastname
		contactverifyinformationPage coninfo = new contactverifyinformationPage(driver);
		String LNverifytext = coninfo.getln().getText();
		softobj.softAssertusingboolean(LNverifytext, CONTACTLN);
//		if (LNverifytext.equals(CONTACTLN)) {
//			System.out.println(CONTACTLN + " contact verfied sucessfully");
//		} else {
//			System.out.println(CONTACTLN + " contact not  verfied ");
//		}
		// to verify email in information page
		String emailverifytext = coninfo.getemail().getText();
		softobj.softAssertusingboolean(emailverifytext, updatedemail);
//		if (emailverifytext.equals(updatedemail)) {
//			System.out.println(updatedemail + " EMAIL verfied sucessfully");
//		} else {
//			System.out.println(updatedemail + " EMAIL  Is not  verfied ");
//		}

		// navigate to email link
		hp.getEmailLink().click();

		// click on compose link
		EmailLinkPage elink = new EmailLinkPage(driver);
		elink.getCompose().click();

		// switch to windows
		wlib.switchToTabOnurl(driver, "EmailsAjax&file=EditView");
		// to click on plus icon
		ComposeLinkPage clink = new ComposeLinkPage(driver);
		Thread.sleep(2000);
		clink.getplusiconinComposeLinkpage().click();
		// switch to windows
		wlib.switchToTabOnurl(driver, "Contacts&action");

		SelectContactforemailPage selcon = new SelectContactforemailPage(driver);
		selcon.getselectcontact().sendKeys(CONTACTLN);
		selcon.getclicksearchbtn().click();

		driver.findElement(By.xpath("//a[contains(text(),'" + CONTACTLN + "')]")).click();
		// switch to windows
		wlib.switchToTabOnurl(driver, "EmailsAjax&file=EditView");
		// to write subject
		clink.getsubject().sendKeys("Hi i am " + CONTACTLN);
		clink.getclickonSavebtn().click();
		// switch to
		wlib.switchToTabOnurl(driver, "module=Emails&action");

		// click on contacts
		elink.getToContactslink().click();
		Thread.sleep(5000);
		

		

		
		// validating whether it is present
		driver.findElement(By.xpath("//td[contains(text(),'" + updatedemail + "')]")).click();
		Thread.sleep(2000);
		// if present get screenshot
		WebElement fulldetailsofemailsent = elink.getemailsent();
		wlib.getscreenshotofElement(fulldetailsofemailsent, "./ScreenShots/email.jpeg");
		softobj.assertALL();
	}

	@Test(groups = "Regression Test")
	public void ReportofOrgnContactTC06Pom() throws Throwable {
		// excel connection
		String Report = elib.getDataFromExcel("Report", 1, 2) + jlib.getRandomNumber();

		HomePage hp = new HomePage(driver);

		hp.MouseoveronMore(driver);
		hp.getclickonReport().click();

		// to click on Contacts by Organizations
		ViewReportsPage vrep = new ViewReportsPage(driver);
		vrep.getviewroportbyconbyOrg().click();
		ContactbyORgofReports filter = new ContactbyORgofReports(driver);
		wlib.selectbyVisibleText(filter.getfilterdd(), "contains");

		filter.getOrgname("Facebook_7");
		filter.getGeneratenow().click();

		// verify ele
		WebElement elefound = driver.findElement(By.xpath("//td[text()='Facebook_7']"));
		String elefoundtext = elefound.getText();
		softobj.softAssertusingboolean(elefoundtext, "Facebook_7");
		softobj.assertALL();
//		if (elefoundtext.contains("Facebook_7")) {
//			System.out.println(elefoundtext + " verfied sucessfully");
//		} else {
//			System.out.println(elefoundtext + "  Is not  verfied ");
//		}

	}

}
