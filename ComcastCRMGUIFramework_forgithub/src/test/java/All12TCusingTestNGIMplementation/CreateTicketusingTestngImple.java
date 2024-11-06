package All12TCusingTestNGIMplementation;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.objectRepositoryutility.CreateTicketPage;
import com.comcast.crm.objectRepositoryutility.HomePage;
import com.comcast.crm.objectRepositoryutility.TicketinformationPage;
import com.crm.generic.Baseutility.BaseTestforRealProject;

public class CreateTicketusingTestngImple extends BaseTestforRealProject{
	@Test(groups = "Smoke Test")
	public void CreateTicket1() throws Throwable
	{
		// excel connection
		String TicketTitle = elib.getDataFromExcel("Ticket", 1, 2) + jlib.getRandomNumber();

		HomePage hp = new HomePage(driver);

		// to select ticket from dropdown
		hp.selectTicketfromDD();

		// enter text into tickettitel and click on save button
		CreateTicketPage tt = new CreateTicketPage(driver);
		tt.EnterTickettitel(TicketTitle);
		tt.getsavebtn().click();

		// confirmation of tcket title
		TicketinformationPage tconf = new TicketinformationPage(driver);
		Thread.sleep(2000);
		String titleverifytext = tconf.getTicketconftext().getText();
		softobj.softAssertusingboolean(titleverifytext, TicketTitle);
		softobj.assertALL();
		
//		if (titleverifytext.equals(TicketTitle)) {
//			System.out.println(TicketTitle + "   is verfied");
//		} else {
//			System.out.println(TicketTitle + "   is not verfied");
//		}


	}

}
