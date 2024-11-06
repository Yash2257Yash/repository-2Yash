package com.comcast.crm.objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Createoppertunitypage {
	WebDriver driver;

	public Createoppertunitypage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@name='potentialname']")
	private WebElement enteroppname;
	

	public WebElement getCreateoppertunitypage() {
		return enteroppname;
	}

	//click on related to
	@FindBy(xpath = "//input[@id='related_to_display']/following-sibling::img")
			private WebElement clickonRelatedtoplus;
	public WebElement getclickonRelatedtoplus()
	{
		return clickonRelatedtoplus;
	}

}
