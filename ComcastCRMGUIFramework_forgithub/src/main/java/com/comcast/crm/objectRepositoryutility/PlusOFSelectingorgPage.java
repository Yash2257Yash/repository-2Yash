package com.comcast.crm.objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlusOFSelectingorgPage {
String ORGNAME="";
	WebDriver driver;
	public PlusOFSelectingorgPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	@FindBy(xpath="//input[@id='search_txt']")
	private WebElement plusiconoforgwithincontactsearchfield;
	public WebElement getplusiconoforgwithincontactsearchfield()
	{
		return plusiconoforgwithincontactsearchfield;
	}
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchbutton;
	public WebElement sendorgnametotext()
	{
		return searchbutton;
	}
	
	@FindBy(xpath="//a[@href=\"javascript:window.close();\"]")
	private WebElement clickonsearchedtext;
	public WebElement getclickonsearchedtext()
	{
		return clickonsearchedtext;
	}
	public void searchfororgfrompopupoforg(String orgname) throws InterruptedException
	{
		plusiconoforgwithincontactsearchfield.sendKeys(orgname);
		searchbutton.click();
		Thread.sleep(2000);
		clickonsearchedtext.click();
	}
	
	
	
}
