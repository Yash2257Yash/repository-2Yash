package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateOrganizationwithPhonenumTest {
	public static void main(String[] args) throws Throwable {
		JavaUtility jlib = new JavaUtility();
		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		String URL = flib.getDataFromPropertiesFile("url");
		String UN = flib.getDataFromPropertiesFile("un");
		String PWD = flib.getDataFromPropertiesFile("pwd");
		String BROWSER = flib.getDataFromPropertiesFile("browser");

		String ORGNAME = elib.getDataFromExcel("Createorg", 7, 2) + jlib.getRandomNumber();

		String PhoneNumber = elib.getDataFromExcel("Createorg", 7, 3);

		WebDriver driver = wlib.browserselect(BROWSER);

		wlib.waitForPageToLoad(driver);
		driver.get(URL);
		// login
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(UN);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PWD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
//enter orgname
		WebElement Orgname = driver.findElement(By.xpath("//input[@name='accountname']"));
		Orgname.sendKeys(ORGNAME);
		// to enter phoneNumber
		WebElement PhoneNum = driver.findElement(By.xpath("//input[@id='phone']"));
		PhoneNum.sendKeys(PhoneNumber);

//click on save button
		driver.findElement(By.xpath("(//input[@value='  Save  '])[2]")).click();
		Thread.sleep(2000);

		// to verify phonenumber
		WebElement phnoverify = driver.findElement(By.xpath("//span[@id='dtlview_Phone']"));
		String phnoverifytext = phnoverify.getText();
		if (phnoverifytext.equals(PhoneNumber)) {
			System.out.println(PhoneNumber + " is verfied sucessfully");
		} else {
			System.out.println(PhoneNumber + " is not  verfied ");
		}

		// logout
		WebElement logout_mouse = driver.findElement(By.xpath("(//td[@class='small'])[2]"));
		wlib.mousemoveonelement(driver, logout_mouse);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		wlib.quitwindow(driver);
	}

}
