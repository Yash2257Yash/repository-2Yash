package com.comcast.crm.objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsLinkPage {
	WebDriver driver;

	public LeadsLinkPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	
	
	
	@FindBy(xpath ="//img[@title='Create Lead...']")
	private WebElement createLead;
	
	
	public WebElement getcreateLead() {
		return createLead;
	}

}
