package com.comcast.crm.contacttestPOM;

import org.openqa.selenium.WebDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectRepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectRepositoryutility.HomePage;
import com.comcast.crm.objectRepositoryutility.LoginPage;
import com.comcast.crm.objectRepositoryutility.OrganizationsLinkPage;
import com.comcast.crm.objectRepositoryutility.contactverifyinformationPage;

public class CreatecontactTestpom {
	public static void main(String[] args) throws Throwable {
		JavaUtility jlib=new JavaUtility();
		
		//create objects
	FileUtility flib=new FileUtility();
	ExcelUtility elib=new ExcelUtility();
	WebDriverUtility wlib=new  WebDriverUtility();
	
	
		String URL = flib.getDataFromPropertiesFile("url");
		String UN = flib.getDataFromPropertiesFile("un");
		String PWD = flib.getDataFromPropertiesFile("pwd");
		String BROWSER = flib.getDataFromPropertiesFile("browser");

		// excel connection
		
		String CONTACTLN =elib.getDataFromExcel("Contact", 1, 2) + jlib.getRandomNumber();
		
		//launch browser
		WebDriver driver = wlib.browserselect(BROWSER);
		wlib.waitForPageToLoad(driver);
		driver.get(URL);
		// login
		LoginPage lp=new LoginPage(driver);
		lp.logintoApp("admin", "admin");
		//click on contact link
		HomePage hp=new HomePage(driver);
		hp.Conatctlink().click();
		//to click on plus icon
		OrganizationsLinkPage plusicon=new OrganizationsLinkPage(driver);
		plusicon.clickonplus().click();
		// enter lastname and click on save button
		CreateNewContactPage enterln=new CreateNewContactPage(driver); 
		enterln.enterlNandsave(CONTACTLN);
		enterln.getClickonsavebtn().click();
			//verify lastname
		contactverifyinformationPage coninfo=new contactverifyinformationPage(driver);
		String	LNverifytext=coninfo.getln().getText();
			
			if (LNverifytext.equals(CONTACTLN)) {
				System.out.println(CONTACTLN + " contact verfied sucessfully");
			} else {
				System.out.println(CONTACTLN+ " contact not  verfied ");
			}

		wlib.quitwindow(driver);
	}

}
