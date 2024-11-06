package TaskofVTIGER6TCown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectRepositoryutility.Createoppertunitypage;
import com.comcast.crm.objectRepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectRepositoryutility.HomePage;
import com.comcast.crm.objectRepositoryutility.LoginPage;
import com.comcast.crm.objectRepositoryutility.OppertunitiesInformationPage;
import com.comcast.crm.objectRepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectRepositoryutility.OrganizationsLinkPage;
import com.comcast.crm.objectRepositoryutility.Relatedtopage;
import com.comcast.crm.objectRepositoryutility.createNewOppertunitiesPage;

public class CREATEOPPERTUNITIESTASK01pom {

	public static void main(String[] args) throws Throwable {
		JavaUtility jlib=new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		ExcelUtility elib=new ExcelUtility();
		FileUtility flib=new FileUtility();
		
		
		String URL = flib.getDataFromPropertiesFile("url");
		String UN = flib.getDataFromPropertiesFile("un");
		String PWD = flib.getDataFromPropertiesFile("pwd");
		String BROWSER = flib.getDataFromPropertiesFile("browser");
		
		
		String Oppetyname1 = elib.getDataFromExcel("Documents", 7, 2) + jlib.getRandomNumber();
		
		
		String ORGNAME = elib.getDataFromExcel("Documents", 7, 1)+jlib.getRandomNumber();
		

		
		WebDriver driver = wlib.browserselect(BROWSER);

		wlib.waitForPageToLoad(driver);
		driver.get(URL);
		// login to app
		LoginPage lp = new LoginPage(driver);
		lp.logintoApp("admin", "admin");
	//create org
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		// click on org link
				HomePage hp = new HomePage(driver);
				hp.getOrgLink().click();
				// cclick on create org plus icon
				OrganizationsLinkPage createneworg = new OrganizationsLinkPage(driver);
				createneworg.clickonplus().click();
				// enter orgname
				CreatingNewOrganizationPage enterorgnamebyusingphno = new CreatingNewOrganizationPage(driver);
				enterorgnamebyusingphno.createorg(ORGNAME);
				enterorgnamebyusingphno.getClickonsavebtn().click();
				OrganizationInformationPage orginfo = new OrganizationInformationPage(driver);
				String actorg = orginfo.getHeadermsg().getText();
				if (actorg.contains(ORGNAME)) {
					System.out.println(ORGNAME + "is verified");
				} else {
					System.out.println(ORGNAME + "is not verified");
				}
Thread.sleep(2000);
				//click oppertunities link 
				hp.getcreateNewopperty().click();
				//click on create oppertunities plus icon
				createNewOppertunitiesPage pos=new createNewOppertunitiesPage(driver);
				pos.getcreateNewoppertunities().click();
				Createoppertunitypage crt=new Createoppertunitypage(driver);
				crt.getCreateoppertunitypage().sendKeys(Oppetyname1);
				crt.getclickonRelatedtoplus().click();
				
				//switch to tab
				wlib.switchToTabOnurl(driver, "module=Accounts");
						
					//related page
				Relatedtopage rel=new Relatedtopage(driver);
				rel.enterrelatednamenclick(ORGNAME);
			
		
				wlib.switchToTabOnurl(driver, "module=Potentials");
				//click on save
				pos.getsavebtn().click();
				
				OppertunitiesInformationPage oppinfo = new OppertunitiesInformationPage(driver);
				String actopp = oppinfo.getHeadermsg().getText();
				if (actopp.contains(Oppetyname1)) {
					System.out.println(Oppetyname1 + "is verified");
				} else {
					System.out.println(Oppetyname1 + "is not verified");
				}
		//logout
				hp.logout();
				wlib.quitwindow(driver);
		

	}

}
