package com.comcast.crm.objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewLeadsPage {

	public CreateNewLeadsPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath="//input[@name='lastname']")
			private WebElement LeadLastName;
	public WebElement getLeadLastName()
	{
		return LeadLastName;
	}
	@FindBy(xpath="//input[@name='company']")
	private WebElement compayname;
public WebElement getcompayname()
{
return compayname;
}
@FindBy(xpath="(//input[@value='  Save  '])[1]")
private WebElement clickonsavebtn;
public WebElement getClickonsavebtn() {
	return clickonsavebtn;
}
	
	public void getLeadsLastNamewithcompany(String Ln,String companyname)
	{
		LeadLastName.sendKeys(Ln);
		compayname.sendKeys(companyname);
	}
	
	
	
	
	
}
