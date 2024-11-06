package Prcatice.pom.repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTestWithoutpom {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		WebElement ele1=driver.findElement(By.xpath("//input[@name='user_name']"));
		ele1.sendKeys("admin");
		WebElement ele2=driver.findElement(By.xpath("//input[@name='user_password']"));
		ele2.sendKeys("admin");
		driver.navigate().refresh();
		ele1.sendKeys("admin");
		ele2.sendKeys("admin");
		WebElement ele3=driver.findElement(By.xpath("//input[@id='submitButton']"));
		ele3.click();

		
	}
}
