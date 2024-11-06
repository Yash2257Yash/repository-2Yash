package Practice.testng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class SampleTestforScreenshot {
	@Test
	public void amazonTest() throws IOException
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://amazon.com");
		//step_1:create an obj to EventFiringWEbDriver 
		EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
		File srcfile = edriver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile,new File("./ScreenShots/abc.png"));
		
		
	}

}
