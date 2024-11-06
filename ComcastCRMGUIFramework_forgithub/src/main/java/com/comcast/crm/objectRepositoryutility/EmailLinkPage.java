

package com.comcast.crm.objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailLinkPage {
	WebDriver driver;

	public EmailLinkPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	 @FindBy(linkText = "Compose")
			
	private WebElement ComposeLink;

	public WebElement getCompose() {
		return ComposeLink;
	}
	
	@FindBy(xpath="//a[text()='To Contacts']")
	
	private WebElement ToContactslink;

	public WebElement getToContactslink() {
		return ToContactslink;
	}
	@FindBy(xpath="(//td[@class='MatrixLayer2'])[1]//table")
	
	private WebElement emailsent;

	public WebElement getemailsent() {
		return emailsent;
	}

//	public WebDriver getDriver() {
//		return driver;
//	}
//	public WebElement getCreateNeworgbtn() {
//		return createNeworgbtn;
//	}
//	public WebElement getSaerchEdt() {
//		return saerchEdt;
//	}
//	public WebElement getSaerchDD() {
//		return saerchDD;
//	}
//
//	@FindBy(name = "search_text")
//	private WebElement saerchEdt;
//	@FindBy(name = "search_field")
//	private WebElement saerchDD;
//	
	@FindBy(xpath = "//img[@src='themes/images/next.gif']")
	private WebElement Nextpagebtn;
	public WebElement getNextpagebtn() {
		return Nextpagebtn;
	}

}
