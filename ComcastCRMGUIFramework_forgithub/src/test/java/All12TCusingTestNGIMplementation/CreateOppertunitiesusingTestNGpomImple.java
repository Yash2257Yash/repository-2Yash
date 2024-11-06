package All12TCusingTestNGIMplementation;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.objectRepositoryutility.Createoppertunitypage;
import com.comcast.crm.objectRepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectRepositoryutility.HomePage;
import com.comcast.crm.objectRepositoryutility.OppertunitiesInformationPage;
import com.comcast.crm.objectRepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectRepositoryutility.OrganizationsLinkPage;
import com.comcast.crm.objectRepositoryutility.Relatedtopage;
import com.comcast.crm.objectRepositoryutility.createNewOppertunitiesPage;
import com.crm.generic.Baseutility.BaseTestforRealProject;

import AssertUtility.SoftAssertCalling;
@Listeners(com.comcast.crm.listenerUtility.ListenerImplementationclass.class)
public class CreateOppertunitiesusingTestNGpomImple extends BaseTestforRealProject {

	@Test(groups = "Smoke Test")
	public void CreateOppertunities() throws Throwable {
		String Oppetyname1 = elib.getDataFromExcel("Documents", 7, 2) + jlib.getRandomNumber();

		String ORGNAME = elib.getDataFromExcel("Documents", 7, 1) + jlib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		// cclick on create org plus icon
		OrganizationsLinkPage createneworg = new OrganizationsLinkPage(driver);
		createneworg.clickonplus().click();
		// enter orgname
		CreatingNewOrganizationPage enterorgnamebyusingphno = new CreatingNewOrganizationPage(driver);
		enterorgnamebyusingphno.createorg(ORGNAME);
		// enterorgnamebyusingphno.getClickonsavebtn().click();
		OrganizationInformationPage orginfo = new OrganizationInformationPage(driver);
		String actorg = orginfo.getHeadermsg().getText();
		System.out.println("org");
		hardobj.hardAssertforboolean(actorg, ORGNAME);
		
		
//		if (actorg.contains(ORGNAME)) {
//			System.out.println(ORGNAME + "is verified");
//		} else {
//			System.out.println(ORGNAME + "is not verified");
//		}
		Thread.sleep(2000);
		// click oppertunities link
		hp.getcreateNewopperty().click();
		// click on create oppertunities plus icon
		createNewOppertunitiesPage pos = new createNewOppertunitiesPage(driver);
		pos.getcreateNewoppertunities().click();
		Createoppertunitypage crt = new Createoppertunitypage(driver);
		crt.getCreateoppertunitypage().sendKeys(Oppetyname1);
		crt.getclickonRelatedtoplus().click();

		// switch to tab
		wlib.switchToTabOnurl(driver, "module=Accounts");

		// related page
		Relatedtopage rel = new Relatedtopage(driver);
		rel.enterrelatednamenclick(ORGNAME);

		wlib.switchToTabOnurl(driver, "module=Potentials");
		// click on save
		pos.getsavebtn().click();

		OppertunitiesInformationPage oppinfo = new OppertunitiesInformationPage(driver);
		String actopp = oppinfo.getHeadermsg().getText();
//		boolean actval1 = actopp.contains(Oppetyname1);
//		Assert.assertTrue(actval1);
		softobj.softAssertusingboolean(actopp, Oppetyname1);
		softobj.assertALL();
		
//		if (actopp.contains(Oppetyname1)) {
//			System.out.println(Oppetyname1 + "is verified");
//		} else {
//			System.out.println(Oppetyname1 + "is not verified");
//		}

	}

}
