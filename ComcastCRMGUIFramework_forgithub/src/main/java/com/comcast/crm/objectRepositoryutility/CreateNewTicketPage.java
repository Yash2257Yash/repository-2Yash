package com.comcast.crm.objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewTicketPage {
	WebDriver driver=null;
	public  CreateNewTicketPage(WebDriver driver)
	{
		this.driver=driver;
PageFactory.initElements(driver, this);
	}
	
	
	
	
}
