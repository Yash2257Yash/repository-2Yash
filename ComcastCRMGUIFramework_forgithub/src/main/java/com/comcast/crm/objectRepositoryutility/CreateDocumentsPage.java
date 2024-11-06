package com.comcast.crm.objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateDocumentsPage {
WebDriver driver;
	public CreateDocumentsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
		
	}
	@FindBy(xpath="//input[@name='notes_title']")
	private WebElement enterdoctitle;
	// getters
	public WebElement getenterdoctitle()
	{
		return enterdoctitle;
	}
	@FindBy(xpath="(//input[@value='  Save  '])[1]")
	private WebElement clickonsavebtn;
	public WebElement getClickonsavebtn() {
		return clickonsavebtn;
	}
	
	public void CreateDocbyenteringdetails(String doctitle)
	{
		enterdoctitle.sendKeys(doctitle);
		
		clickonsavebtn.click();
	}
	
	
}
