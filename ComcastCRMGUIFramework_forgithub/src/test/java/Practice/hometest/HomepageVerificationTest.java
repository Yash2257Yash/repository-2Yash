package Practice.hometest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomepageVerificationTest {

	@Test
	public void homepageTest(Method mtd) {
		System.out.println(mtd + "   Test start");
		String ExpectedPage = "Home Page";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		// login
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		String actTitle = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
//		if (actTitle.trim().equals(ExpectedPage)) {
//			System.out.println(ExpectedPage + "is verified");
//		} else {
//			System.out.println(ExpectedPage + "is not verified ");
//		}
		
		Assert.assertEquals(true, actTitle);
		System.out.println(mtd.getName()+"Test END");
driver.close();
	}

	@Test
	public void VerifyLogoHomePageTest(Method mtd1) {
		
			System.out.println(mtd1 + "   Test start");
			
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("http://localhost:8888");
		boolean status=	driver.findElement(By.xpath("//img[@src='test/logo/vtiger-crm-logo.gif']")).isEnabled();
//		if (status) {
//			System.out.println( "Logo is verified");
//		} else {
//			System.out.println( " LOgo is not verified ");
//		}
		Assert.assertTrue(status);
			
			System.out.println(mtd1.getName()+"Test END");
driver.close();
	}

}
