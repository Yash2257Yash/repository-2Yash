package com.comcast.crm.objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsInformationPage {

	public LeadsInformationPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

@FindBy(xpath ="//span[@id='dtlview_Last Name']") 
	private WebElement headermsg;

	public WebElement getHeadermsg() {
		return headermsg;
	}
	@FindBy(xpath ="//span[@id='dtlview_Company']") 
	private WebElement compheadermsg;

	public WebElement getcompHeadermsg() {
		return compheadermsg;
	}

}
