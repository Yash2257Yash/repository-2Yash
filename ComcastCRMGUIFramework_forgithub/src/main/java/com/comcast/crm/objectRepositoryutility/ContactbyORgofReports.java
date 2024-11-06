package com.comcast.crm.objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactbyORgofReports {
	WebDriver driver;

	public ContactbyORgofReports(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	
	
	@FindBy(xpath ="//input[@id='fval0']")
	private WebElement sendingtext;
	
	
	public WebElement getsendingtext() {
		return sendingtext;
	}

	
	@FindBy(xpath ="//select[@class='repBox']")
	private WebElement filterdd;
	
	
	public WebElement getfilterdd() {
		return filterdd;
	}
	
	@FindBy(xpath ="//input[@title='Generate Now']")
	private WebElement Generatenow;
	
	
	public WebElement getGeneratenow() {
		return Generatenow;
	}
	public void getOrgname(String Text)
	{
		sendingtext.sendKeys(Text);
	}
	
	
}
