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

public class CreatecontactWithSupportDateTestpom {
	public static void main(String[] args) throws Throwable {
		JavaUtility jlib=new JavaUtility();
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		
		//property file
		String URL=flib.getDataFromPropertiesFile("url");
		String BROWSER=flib.getDataFromPropertiesFile("browser");
		String UN=flib.getDataFromPropertiesFile("un");
		String PWD=flib.getDataFromPropertiesFile("pwd");
		// excel connection
		
		String CONTACTLN = elib.getDataFromExcel("Contact", 4, 2)+ jlib.getRandomNumber();
		

		WebDriver driver = wlib.browserselect(BROWSER);
		wlib.waitForPageToLoad(driver);
		driver.get(URL);
		// login
				LoginPage lp = new LoginPage(driver);
				lp.logintoApp("admin", "admin");
				// click on contact link
				HomePage hp = new HomePage(driver);
				hp.getContactLink().click();
				// to click on plus icon
				OrganizationsLinkPage plusicon = new OrganizationsLinkPage(driver);
				plusicon.clickonplus().click();
				// enter lastname and 
				CreateNewContactPage enterln = new CreateNewContactPage(driver);
				enterln.enterlNandsave(CONTACTLN);
	
				CreateNewContactPage plusorg = new CreateNewContactPage(driver);
		
		
		//CreateNewContactPage savethepro = new CreateNewContactPage(driver);

			

			String startDate = jlib.getSystemDateYYYYDDMM();

			String enddate = jlib.getRequiredDateYYYYDDMM(30);

			plusorg.clearandsetthedate(startDate,enddate);
			plusorg.getClickonsavebtn().click();
				
			contactverifyinformationPage cvi=new contactverifyinformationPage(driver);
			
			// to verify startdate
			String startverifytext = cvi.getStartDate().getText();
			if (startverifytext.equals(startDate)) {
				System.out.println(startDate + "  verfied sucessfully");
			} else {
				System.out.println(startDate + "  not  verfied ");
			}
			
			

			// to verify enddate
		String enddateverify =  cvi.getendDate().getText();
			
			if (enddateverify.equals(enddate)) {
				System.out.println(enddate + " verfied sucessfully");
			} else {
				System.out.println(enddate + " not  verfied ");
			}
			
			
			// verify lastname
					String LNverifytext = cvi.getln().getText();

					if (LNverifytext.equals(CONTACTLN)) {
						System.out.println(CONTACTLN + " contact verfied sucessfully");
					} else {
						System.out.println(CONTACTLN + " contact not  verfied ");
					}
			
			

		wlib.quitwindow(driver);
	}

}
