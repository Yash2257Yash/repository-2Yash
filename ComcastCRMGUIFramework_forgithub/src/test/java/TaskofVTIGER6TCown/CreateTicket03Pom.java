package TaskofVTIGER6TCown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectRepositoryutility.CreateTicketPage;
import com.comcast.crm.objectRepositoryutility.HomePage;
import com.comcast.crm.objectRepositoryutility.LoginPage;
import com.comcast.crm.objectRepositoryutility.TicketinformationPage;

public class CreateTicket03Pom {

	public static void main(String[] args) throws Throwable {
		WebDriverUtility wlib = new WebDriverUtility();
		JavaUtility jlib = new JavaUtility();
		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();

		String URL = flib.getDataFromPropertiesFile("url");
		String UN = flib.getDataFromPropertiesFile("un");
		String PWD = flib.getDataFromPropertiesFile("pwd");
		String BROWSER = flib.getDataFromPropertiesFile("browser");

		// excel connection
		String TicketTitle = elib.getDataFromExcel("Ticket", 1, 2) + jlib.getRandomNumber();

		WebDriver driver = wlib.browserselect(BROWSER);

		wlib.waitForPageToLoad(driver);
		driver.get(URL);
		// login to app
		LoginPage lp = new LoginPage(driver);
		lp.logintoApp("admin", "admin");
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

		if (titleverifytext.equals(TicketTitle)) {
			System.out.println(TicketTitle + "   is verfied");
		} else {
			System.out.println(TicketTitle + "   is not verfied");
		}

		hp.logout();
		wlib.quitwindow(driver);

	}
}
