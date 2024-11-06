package com.comcast.crm.objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {

	public OrganizationInformationPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

@FindBy(xpath ="//span[@class ='dvHeaderText']") 
	private WebElement headermsg;

	public WebElement getHeadermsg() {
		return headermsg;
	}

}
