package TaskofVTIGER6TCown;

import org.openqa.selenium.WebDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectRepositoryutility.CreateDocumentsPage;
import com.comcast.crm.objectRepositoryutility.DocLinkPage;
import com.comcast.crm.objectRepositoryutility.DocinfoPage;
import com.comcast.crm.objectRepositoryutility.HomePage;
import com.comcast.crm.objectRepositoryutility.LoginPage;

public class VtigerDocumentTASK02pom {

	public static void main(String[] args) throws Throwable {
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		ExcelUtility elib = new ExcelUtility();
		FileUtility flib = new FileUtility();

		String URL = flib.getDataFromPropertiesFile("url");
		String UN = flib.getDataFromPropertiesFile("un");
		String PWD = flib.getDataFromPropertiesFile("pwd");
		String BROWSER = flib.getDataFromPropertiesFile("browser");

		String DOCTITLES = elib.getDataFromExcel("Documents", 1, 2) + jlib.getRandomNumber();

		WebDriver driver = wlib.browserselect(BROWSER);

		wlib.waitForPageToLoad(driver);
		driver.get(URL);
		// login to app
		LoginPage lp = new LoginPage(driver);
		lp.logintoApp("admin", "admin");
		HomePage hp=new HomePage(driver);
		
		// doc link
		
		hp.getDocumentslink().click();
		
//		// click on plus icon
		
		DocLinkPage doclinkplus=new DocLinkPage(driver);
		doclinkplus.getDocumentslinkplus().click();
		
       //enter title 
		
		CreateDocumentsPage createdoc=new CreateDocumentsPage(driver);
		createdoc.CreateDocbyenteringdetails(DOCTITLES);
		// to verify headerconfirmation
		DocinfoPage docverify=new DocinfoPage(driver);
		String titleverifytext=docverify.getHeadermsg().getText();

		if (titleverifytext.equals(DOCTITLES)) {
			System.out.println(DOCTITLES + " is verfied sucessfully");
		} else {
			System.out.println(DOCTITLES + " is not  verfied ");
		}

hp.logout();
wlib.quitwindow(driver);

	}

}
