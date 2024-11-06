package com.comcast.crm.objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {

	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath="//input[@name='lastname']")
			private WebElement LastName;
	public WebElement getLastName()
	{
		return LastName;
	}
	
	@FindBy(xpath="(//input[@value='  Save  '])[1]")
	private WebElement clickonsavebtn;
	
	
	public WebElement getClickonsavebtn() {
		return clickonsavebtn;
	}
	
	public void enterlNandsave(String LN)
	{
		LastName.sendKeys(LN);
//		clickonsavebtn.click();
	}
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement orgPLusIcon;
	public WebElement getorgPLusIcon()
	{
		return orgPLusIcon;
	}
	@FindBy(xpath="//input[@name='email']")
	private WebElement email;
	public WebElement getemail()
	{
		return email;
	}
	
	@FindAll({@FindBy(name="support_start_date"),@FindBy(id="jscal_field_support_start_date")})
	private WebElement ExistingstartDate;
	public WebElement getExistingstartDate()
	{
		return ExistingstartDate;
	}
	
	
	@FindAll({@FindBy(name="support_end_date"),@FindBy(id="jscal_field_support_end_date")})
	private WebElement ExistingendDate;
	public WebElement getExistingendDate()
	{
		return ExistingendDate;
	}
	
	
	public void clearandsetthedate(String startdate,String enddate) throws InterruptedException
	{		Thread.sleep(3000);

		ExistingstartDate.clear();
		
		ExistingstartDate.sendKeys(startdate);
		

		ExistingendDate.clear();
		

		ExistingendDate.sendKeys(enddate);
		clickonsavebtn.click();
		
	}
	public void contactwithemail(String LN,String emailid) 
	{
		LastName.sendKeys(LN);
		email.sendKeys(emailid);
		clickonsavebtn.click();
		
	}
	
}
