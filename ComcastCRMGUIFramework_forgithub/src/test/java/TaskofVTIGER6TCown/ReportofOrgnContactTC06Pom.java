package TaskofVTIGER6TCown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectRepositoryutility.ContactbyORgofReports;
import com.comcast.crm.objectRepositoryutility.HomePage;
import com.comcast.crm.objectRepositoryutility.LoginPage;
import com.comcast.crm.objectRepositoryutility.ViewReportsPage;

public class ReportofOrgnContactTC06Pom {

	public static void main(String[] args) throws Throwable {
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		ExcelUtility elib = new ExcelUtility();
		FileUtility flib = new FileUtility();

		String URL = flib.getDataFromPropertiesFile("url");
		String UN = flib.getDataFromPropertiesFile("un");
		String PWD = flib.getDataFromPropertiesFile("pwd");
		String BROWSER = flib.getDataFromPropertiesFile("browser");


		// excel connection
		String Report =elib.getDataFromExcel("Report", 1, 2)+jlib.getRandomNumber();
		
		

		// launch browser
				WebDriver driver = wlib.browserselect(BROWSER);

				wlib.waitForPageToLoad(driver);
				driver.get(URL);
				// login to app
				LoginPage lp = new LoginPage(driver);
				lp.logintoApp("admin", "admin");
				HomePage hp = new HomePage(driver);

		hp.MouseoveronMore(driver);
		hp.getclickonReport().click();

		// to click on Contacts by Organizations
ViewReportsPage vrep=new ViewReportsPage(driver);
vrep.getviewroportbyconbyOrg().click();
ContactbyORgofReports filter=new ContactbyORgofReports(driver);
wlib.selectbyVisibleText(filter.getfilterdd(), "contains");

filter.getOrgname("Facebook_7");
filter.getGeneratenow().click();








	//verify ele
		WebElement elefound = driver.findElement(By.xpath("//td[text()='Facebook_7']"));
		String elefoundtext = elefound.getText();

		if (elefoundtext.contains("Facebook_7")) {
			System.out.println(elefoundtext + " verfied sucessfully");
		} else {
			System.out.println(elefoundtext + "  Is not  verfied ");
		}
		

		Thread.sleep(2000);
		hp.logout();
		wlib.quitwindow(driver);
	}
}
