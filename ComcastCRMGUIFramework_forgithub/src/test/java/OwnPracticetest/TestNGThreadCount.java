package OwnPracticetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectRepositoryutility.LoginPage;

public class TestNGThreadCount  {
	WebDriver driver=new ChromeDriver();
	
	
@Test


public void Create() throws Throwable
{		
	 
	driver.get("http://localhost:8888");
	System.out.println("class2=====method1");
	

	}
@Test
public void Createorg() throws Throwable
{	
	driver.manage().window().maximize();
	driver.get("http://localhost:8888");
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("fdg");

	System.out.println("class2======method22");
	driver.quit();
	
	}
}
