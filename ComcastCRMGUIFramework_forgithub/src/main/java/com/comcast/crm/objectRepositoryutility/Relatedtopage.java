package com.comcast.crm.objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Relatedtopage {
	
	WebDriver driver;

	public Relatedtopage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="search_text")
	private WebElement enterrelatedname;
	

	public WebElement getenterrelatedname() {
		return enterrelatedname;
	}
	@FindBy(name="search")
	private WebElement clicksearchbtn;
	

	public WebElement getclicksearchbtn() {
		return clicksearchbtn;
	}
	@FindBy(xpath="//a[@href='javascript:window.close();']")
	private WebElement clickonsearched;
	

	public WebElement getclickonsearched() {
		return clickonsearched;
	}
	
	

public void enterrelatednamenclick(String relname) throws InterruptedException
{
	enterrelatedname.sendKeys(relname);
	clicksearchbtn.click();
	Thread.sleep(2000);
	clickonsearched.click();
}


}
