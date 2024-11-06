package TaskofVTIGER6TCown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CLiniqScenarioTest {
	WebDriverUtility wlib = new WebDriverUtility();

	@Test

	public void DisplayddOptions() throws Throwable

	{
		WebDriver driver = new ChromeDriver();
		wlib.MaximiseBrowser(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://www.clinique.in/");

		driver.findElement(By.xpath("//button[contains(text(),'OK, ACCEPT ALL')]")).click();

		WebElement skincaredd = driver.findElement(By.xpath("(//a[contains(text(),'Skincare')])[2]"));

//		driver.findElement(By.xpath("//button[@aria-label=\"Close Message\"]")).click();
//		System.out.println("message closed");
		Actions acct = new Actions(driver);
		acct.moveToElement(skincaredd).perform();
		Thread.sleep(8000);
		String Data = driver.findElement(By.xpath("(//div[@class='gnav-desktop-sub-nav-content-column space-y-4'])[9]"))
				.getText();
		//driver.findElement(By.xpath("//button[@class='ab-close-button']")).click();

		Thread.sleep(8000);
		System.out.println(Data);

	}

}
