package All12TCusingTestNGIMplementation;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.objectRepositoryutility.CreateNewLeadsPage;
import com.comcast.crm.objectRepositoryutility.HomePage;
import com.comcast.crm.objectRepositoryutility.LeadsInformationPage;
import com.comcast.crm.objectRepositoryutility.LeadsLinkPage;
import com.crm.generic.Baseutility.BaseTestforRealProject;

public class CreateLeadsusingTEstngIMple extends BaseTestforRealProject {

	@Test(groups = "Smoke Test")
	public void CreateLeads() throws Throwable {
		String LASTNAME = elib.getDataFromExcel("Documents", 4, 2) + jlib.getRandomNumber();

		String COMPANY = elib.getDataFromExcel("Documents", 4, 3) + jlib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.getLeadslink().click();
		LeadsLinkPage llp = new LeadsLinkPage(driver);
		// plus of Leads

		llp.getcreateLead().click();

//enter title 
		CreateNewLeadsPage enterln = new CreateNewLeadsPage(driver);
		enterln.getLeadsLastNamewithcompany(LASTNAME, COMPANY);
		enterln.getClickonsavebtn().click();

		// to verify lastnameconfirmation
		LeadsInformationPage Leadinfo = new LeadsInformationPage(driver);
		String LNeverifytext = Leadinfo.getHeadermsg().getText();
		softobj.softAssertusingboolean(LNeverifytext, LASTNAME);

//		if (LNeverifytext.equals(LASTNAME)) {
//			System.out.println(LASTNAME + " is verfied sucessfully");
//		} else {
//			System.out.println(LASTNAME + " is not  verfied ");
//		}
		// to verify company

		String cmpverifytext = Leadinfo.getcompHeadermsg().getText();
		softobj.softAssertusingboolean(cmpverifytext, COMPANY);
		softobj.assertALL();
//		if (cmpverifytext.equals(COMPANY)) {
//			System.out.println(COMPANY + " is verfied sucessfully");
//		} else {
//			System.out.println(COMPANY + " is not  verfied ");
//		}

	}

}
