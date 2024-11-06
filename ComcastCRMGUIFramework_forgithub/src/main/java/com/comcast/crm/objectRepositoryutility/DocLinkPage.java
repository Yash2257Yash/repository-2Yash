package com.comcast.crm.objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocLinkPage {
WebDriver driver=null;
	public DocLinkPage(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements( driver,this);
	}
	@FindBy(xpath ="//img[@title='Create Document...']")
	private WebElement Documentslinkplus;
	// getters
	public WebElement getDocumentslinkplus()
	{
		return Documentslinkplus;
	}

}
