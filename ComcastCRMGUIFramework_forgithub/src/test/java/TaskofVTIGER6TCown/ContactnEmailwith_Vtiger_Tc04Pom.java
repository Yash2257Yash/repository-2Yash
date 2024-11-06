package TaskofVTIGER6TCown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectRepositoryutility.ComposeLinkPage;
import com.comcast.crm.objectRepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectRepositoryutility.EmailLinkPage;
import com.comcast.crm.objectRepositoryutility.HomePage;
import com.comcast.crm.objectRepositoryutility.LoginPage;
import com.comcast.crm.objectRepositoryutility.OrganizationsLinkPage;
import com.comcast.crm.objectRepositoryutility.SelectContactforemailPage;
import com.comcast.crm.objectRepositoryutility.contactverifyinformationPage;

public class ContactnEmailwith_Vtiger_Tc04Pom {

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
		String CONTACTLN = elib.getDataFromExcel("Contact", 1, 2) + jlib.getRandomNumber();

		String EMAIL = elib.getDataFromExcel("Contact", 1, 3);

		String updatedemail = CONTACTLN + EMAIL;
		// launch browser
		WebDriver driver = wlib.browserselect(BROWSER);

		wlib.waitForPageToLoad(driver);
		driver.get(URL);
		// login to app
		LoginPage lp = new LoginPage(driver);
		lp.logintoApp("admin", "admin");
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

		if (LNverifytext.equals(CONTACTLN)) {
			System.out.println(CONTACTLN + " contact verfied sucessfully");
		} else {
			System.out.println(CONTACTLN + " contact not  verfied ");
		}
		// to verify email in information page
		String emailverifytext = coninfo.getemail().getText();

		if (emailverifytext.equals(updatedemail)) {
			System.out.println(updatedemail + " EMAIL verfied sucessfully");
		} else {
			System.out.println(updatedemail + " EMAIL  Is not  verfied ");
		}

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
//switch to 
		wlib.switchToTabOnurl(driver, "module=Emails&action");

		// click on contacts
		elink.getToContactslink().click();
		Thread.sleep(3000);
////click on arrow button and check for 2nd page
//		elink.getNextpagebtn().click();
//		
//		
//		// validating whether it is present
//		driver.findElement(By.xpath("//td[contains(text(),'"+updatedemail+"')]")).click();
//
//		// if present get screenshot
//		WebElement fulldetailsofemailsent = elink.getemailsent();
//		wlib.getscreenshotofElement(fulldetailsofemailsent, "./ScreenShots/email.jpeg");
//		hp.logout();
//		wlib.quitwindow(driver);
	}
}