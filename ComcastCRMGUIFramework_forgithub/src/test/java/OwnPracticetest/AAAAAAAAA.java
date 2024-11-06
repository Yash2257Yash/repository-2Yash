package OwnPracticetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectRepositoryutility.LoginPage;

public class AAAAAAAAA  {
	
	WebDriver driver=new ChromeDriver();
	
@Test()


public void Create21111() throws Throwable
{		
	driver.get("http://localhost:8888");
	System.out.println("class1======Method1111");
	
	}
@Test
public void Createorg222222() throws Throwable
{
	driver.manage().window().maximize();

	driver.get("http://localhost:8888");
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("ad");

	System.out.println("class11111 ====Method222222");
	driver.quit();
	
	}
}
