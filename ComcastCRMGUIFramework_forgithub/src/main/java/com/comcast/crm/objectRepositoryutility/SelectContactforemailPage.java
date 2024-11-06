

package com.comcast.crm.objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectContactforemailPage {
	WebDriver driver;
	
	public SelectContactforemailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	 @FindBy(xpath ="//input[@id='search_txt']")
			
	private WebElement selectcontact;

	public WebElement getselectcontact() {
		return selectcontact;
	}
	 @FindBy(xpath ="//input[@name='search']")
		
		private WebElement clicksearchbtn;

		public WebElement getclicksearchbtn() {
			return clicksearchbtn;
		}
		
		
		@FindBy(xpath="(//input[@value='  Save  '])[1]")
		private WebElement clickonsavebtn;
		
		
		public WebElement getClickonsavebtn() {
			return clickonsavebtn;
		}
		
	

//	public WebDriver getDriver() {
//		return driver;
//	}
//	public WebElement getCreateNeworgbtn() {
//		return createNeworgbtn;
//	}
//	public WebElement getSaerchEdt() {
//		return saerchEdt;
//	}
//	public WebElement getSaerchDD() {
//		return saerchDD;
//	}
//
//	@FindBy(name = "search_text")
//	private WebElement saerchEdt;
//	@FindBy(name = "search_field")
//	private WebElement saerchDD;
//	
//	@FindBy(name = "submit")
//	private WebElement searchBtn;
//	public WebElement getsearchBtn() {
//		return searchBtn;
//	}

}
