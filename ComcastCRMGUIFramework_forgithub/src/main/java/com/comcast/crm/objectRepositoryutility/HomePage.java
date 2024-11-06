package com.comcast.crm.objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
/**
 * @author kmyas
 * Home page object Repository
 */
public class HomePage {
	WebDriver driver;

	// constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	@FindBy(linkText = "Contacts")
	private WebElement contactLink;
	@FindBy(linkText = "Campaigns")
	private WebElement campaignLink;
	@FindBy(linkText = "More")
	private WebElement moreLink;
	@FindBy(xpath ="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminimg;
	@FindBy(linkText = "Sign Out")
	private WebElement SignoutLink;
	@FindBy(linkText = "Contacts")
	private WebElement contactlink;
	// getters
	public WebElement Conatctlink()
	{
		return contactlink;
	}
	
	@FindBy(xpath = "//a[contains(text(),'Documents')]")
	private WebElement Documentslink;
	// getters
	public WebElement getDocumentslink()
	{
		return Documentslink;
	}
	@FindBy(xpath = "//a[contains(text(),'Email')]")
	private WebElement EmailLink;
	// getters
	public WebElement getEmailLink()
	{
		return EmailLink;
	}
	
	@FindBy(linkText = "Leads")
	private WebElement Leadslink;
	public WebElement getLeadslink() {
		return Leadslink;
	}
	
	@FindBy(xpath = "//a[text()='More']")
	private WebElement MOre;
	public WebElement getMOre() {
		return MOre;
	}
	
	@FindBy(xpath ="//a[@name='Reports']")
	private WebElement clickonReport;
	public WebElement getclickonReport() {
		return clickonReport;
	}
	
	/**
	 * 
	 * @param driver
	 */
	
	public void MouseoveronMore(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.moveToElement(MOre).perform();
		
	}
	

	

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getCampaignLink() {
		return campaignLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}
	/**
	 * Logout from the application
	 */
	public void logout() throws InterruptedException
	{
		
		Actions acct=new Actions(driver);
		acct.moveToElement(adminimg).perform();
		Thread.sleep(5000);
		SignoutLink.click();
		System.out.println("Window Quit");
	}
	
	@FindBy(linkText="Opportunities")
	private WebElement createNewopperty;
	

	public WebElement getcreateNewopperty() {
		return createNewopperty;
	}
	
	@FindBy(xpath = "//select[@id='qccombo']")
	private WebElement QuickDD;
	public WebElement getQuickDD()
	{
		return QuickDD;
	}
	
	public void  selectTicketfromDD()
	{
	  Select selTicket=new Select(QuickDD);
	  selTicket.selectByVisibleText("New Ticket");
	}
	


	
//	//Navigate to Campaign link
//		public void navigatetocampaignLink()
//		{
//			Actions act=new Actions(driver);
//			act.moveToElement(moreLink);
//			campaignLink.click();
//		}


}
