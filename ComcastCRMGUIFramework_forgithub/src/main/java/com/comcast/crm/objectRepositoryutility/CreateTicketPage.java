package com.comcast.crm.objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateTicketPage {

	WebDriver driver = null;

	public CreateTicketPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//textarea[@name='ticket_title']")
	private WebElement Tickettitel;

	public WebElement getTickettitel()
	{
		return Tickettitel;
	}

	

	@FindBy(xpath = "(//input[@class='crmbutton small save'])[1]")

	private WebElement savebtn;
	public WebElement getsavebtn()
	{
		return savebtn;
	}

	
	public void EnterTickettitel(String Ttitle) {
		Tickettitel.sendKeys(Ttitle);
	}

}
