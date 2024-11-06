package ClinqOPR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClinqSkincarePage {
	WebDriver driver;
	
	public void ClinqScenario(WebDriver driver)
	
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	@FindBy(xpath="(//a[contains(text(),'Skincare')])[2]")
	private WebElement skincaredd;

	public WebElement getSkincar() {
		return skincaredd;
	}
	
	@FindBy(xpath="(//div[@class='gnav-desktop-sub-nav-content-column space-y-4'])[2]")
	private WebElement options;

	public WebElement getoptions() {
		return options;
	}
	
	
	public void mouseoveronskincare()
	{
		Actions acct=new Actions(driver);
		acct.moveToElement(skincaredd).perform();
//		getoptions().getText();
//		
		
	}

}
