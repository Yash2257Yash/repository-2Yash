package All12TCusingTestNGIMplementation;

import org.testng.annotations.Test;

import com.comcast.crm.objectRepositoryutility.CreateDocumentsPage;
import com.comcast.crm.objectRepositoryutility.DocLinkPage;
import com.comcast.crm.objectRepositoryutility.DocinfoPage;
import com.comcast.crm.objectRepositoryutility.HomePage;
import com.crm.generic.Baseutility.BaseTestforRealProject;

public class CreateDocumentusingTEstNgIMple extends BaseTestforRealProject{

	@Test(groups = "Smoke Test")
	public void CreateDocument() throws Throwable {
		String DOCTITLES = elib.getDataFromExcel("Documents", 1, 2) + jlib.getRandomNumber();

		HomePage hp = new HomePage(driver);

		// doc link

		hp.getDocumentslink().click();

//		// click on plus icon

		DocLinkPage doclinkplus = new DocLinkPage(driver);
		doclinkplus.getDocumentslinkplus().click();

		// enter title

		CreateDocumentsPage createdoc = new CreateDocumentsPage(driver);
		createdoc.CreateDocbyenteringdetails(DOCTITLES);
		// to verify headerconfirmation
		DocinfoPage docverify = new DocinfoPage(driver);
		String titleverifytext = docverify.getHeadermsg().getText();
		softobj.softAssertusingboolean(titleverifytext, DOCTITLES);
		softobj.assertALL();
//		if (titleverifytext.equals(DOCTITLES)) {
//			System.out.println(DOCTITLES + " is verfied sucessfully");
//		} else {
//			System.out.println(DOCTITLES + " is not  verfied ");
//		}

	}
}
