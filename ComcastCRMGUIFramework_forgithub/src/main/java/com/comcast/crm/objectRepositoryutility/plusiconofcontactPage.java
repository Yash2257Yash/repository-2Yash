package com.comcast.crm.objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class plusiconofcontactPage {
	
	WebDriver driver;
	public WebElement getPlusofcontact() {
		return plusofcontact;
	}

	public plusiconofcontactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@title='Create Contact...'")
	private WebElement plusofcontact;
	
}
