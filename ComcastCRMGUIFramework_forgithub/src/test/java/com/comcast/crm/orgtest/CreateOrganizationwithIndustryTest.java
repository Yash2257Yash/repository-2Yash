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

public class CreateOrganizationwithIndustryTest {
	public static void main(String[] args) throws Throwable {
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		
		String URL = flib.getDataFromPropertiesFile("url");
		String UN = flib.getDataFromPropertiesFile("un");
		String PWD = flib.getDataFromPropertiesFile("pwd");
		String BROWSER =flib.getDataFromPropertiesFile("browser");

		
		
		String ORGNAME = elib.getDataFromExcel("Createorg", 4, 2) + jlib.getRandomNumber();
		String Industry =elib.getDataFromExcel("Createorg", 4, 3);
		String Type = elib.getDataFromExcel("Createorg", 4, 4);

		
		WebDriver driver = wlib.browserselect(BROWSER);
		wlib.waitForPageToLoad(driver);
		driver.get(URL);
       //login
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(UN);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PWD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
//enter orgname
		WebElement Orgname = driver.findElement(By.xpath("//input[@name='accountname']"));
		Orgname.sendKeys(ORGNAME);
		//select industry dd
		
		WebElement Industrydd = driver.findElement(By.xpath("//select[@name='industry']"));
		wlib.select(Industrydd, Industry);
		
		//select Type dd
		WebElement Typedd = driver.findElement(By.xpath("//select[@name='accounttype']"));
		wlib.select(Typedd, Type);
		
		
		
//click on save button
		driver.findElement(By.xpath("(//input[@value='  Save  '])[2]")).click();
		Thread.sleep(2000);

		//verify industry
		WebElement industrynameverify = driver.findElement(By.xpath("//span[@id='dtlview_Industry']"));
		String industrynameverifytext = industrynameverify.getText();
		if (industrynameverifytext.equals(Industry)) {
			System.out.println(Industry + "is verfied sucessfully");
		} else {
			System.out.println(Industry + "is not  verfied ");
		}
		//to verify Type
		WebElement Typeverify = driver.findElement(By.xpath("//span[@id='dtlview_Industry']"));
		String Typeverifyverifytext = Typeverify.getText();
		if (Typeverifyverifytext.equals(Type)) {
			System.out.println(Type + "is verfied sucessfully");
		} else {
			System.out.println(Type + "is not  verfied ");
		}
		
		

		
		// logout
		WebElement logout_mouse = driver.findElement(By.xpath("(//td[@class='small'])[2]"));
		wlib.mousemoveonelement(driver, logout_mouse);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		wlib.quitwindow(driver);

	}

}
