package com.comcast.crm.objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsLinkPage {
	WebDriver driver;

	public OrganizationsLinkPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']"),
			@FindBy(xpath = "//img[@alt='Create Organization...']") })
	private WebElement createNeworgbtn;

	public WebElement clickonplus() {
		return createNeworgbtn;
	}

	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getCreateNeworgbtn() {
		return createNeworgbtn;
	}
	public WebElement getSaerchEdt() {
		return saerchEdt;
	}
	public WebElement getSaerchDD() {
		return saerchDD;
	}

	@FindBy(name = "search_text")
	private WebElement saerchEdt;
	@FindBy(name = "search_field")
	private WebElement saerchDD;
	
	@FindBy(name = "submit")
	private WebElement searchBtn;
	public WebElement getsearchBtn() {
		return searchBtn;
	}

}
