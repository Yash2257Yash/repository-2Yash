package com.comcast.crm.objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TicketinformationPage {
	WebDriver driver;

	public TicketinformationPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//span[@id='dtlview_Title']")
	private WebElement Ticketconftext;

	public WebElement getTicketconftext() {
		return Ticketconftext;
	}

}
