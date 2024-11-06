package TaskofVTIGER6TCown;

import org.openqa.selenium.WebDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectRepositoryutility.CreateNewLeadsPage;
import com.comcast.crm.objectRepositoryutility.HomePage;
import com.comcast.crm.objectRepositoryutility.LeadsInformationPage;
import com.comcast.crm.objectRepositoryutility.LeadsLinkPage;
import com.comcast.crm.objectRepositoryutility.LoginPage;

public class VtigerLEADSTASK05pom {

	public static void main(String[] args) throws Throwable {
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		ExcelUtility elib = new ExcelUtility();
		FileUtility flib = new FileUtility();

		String URL = flib.getDataFromPropertiesFile("url");
		String UN = flib.getDataFromPropertiesFile("un");
		String PWD = flib.getDataFromPropertiesFile("pwd");
		String BROWSER = flib.getDataFromPropertiesFile("browser");
		String LASTNAME = elib.getDataFromExcel("Documents", 4, 2) + jlib.getRandomNumber();

		String COMPANY = elib.getDataFromExcel("Documents", 4, 3) + jlib.getRandomNumber();

		// launch browser
		WebDriver driver = wlib.browserselect(BROWSER);

		wlib.waitForPageToLoad(driver);
		driver.get(URL);
		// login to app
		LoginPage lp = new LoginPage(driver);
		lp.logintoApp("admin", "admin");
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

		if (LNeverifytext.equals(LASTNAME)) {
			System.out.println(LASTNAME + " is verfied sucessfully");
		} else {
			System.out.println(LASTNAME + " is not  verfied ");
		}
		// to verify company
		
		String cmpverifytext =Leadinfo.getcompHeadermsg().getText();

		if (cmpverifytext.equals(COMPANY)) {
			System.out.println(COMPANY + " is verfied sucessfully");
		} else {
			System.out.println(COMPANY + " is not  verfied ");
		}
hp.logout();
wlib.quitwindow(driver);
	}

}
